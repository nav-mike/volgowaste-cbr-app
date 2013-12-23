/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cbrapp;

import cbrapp.gui.MainWindow;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRQuery;
import jcolibri.datatypes.Instance;
import jcolibri.exception.ExecutionException;
import jcolibri.exception.OntologyAccessException;

/**
 *
 * @author M. Navrotskiy
 */
public class CbrApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if (args.length == 0) {
            MainWindow mainWindow = new MainWindow("http://www.owl-ontologies.com/vw_cbr.owl#");
        } else {

            CbrApplication app = new CbrApplication();
            String cbrResult = cbr(args);

            ArrayList list = ReadSolutions.getSolutionsText(cbrResult);

            writeResult(list);
        }
    }
    
    /**
     * Функция записи результата CBR в файл.
     * @param result Результат работы CBR.
     */
    private static void writeResult (ArrayList<String> result) {
        try {
            PrintWriter out = new PrintWriter("result.txt");
            
            for (String item : result) {
                out.println(item);
            }
            
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CbrApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Функция выполнения CBR.
     * @param value Значение, введенное пользователем.
     * @return Результат CBR анализа.
     */
    private static String cbr (String[] values) {
        try {
            String result = "";
            CbrApplication app = new CbrApplication();
            app.configure();
            app.preCycle();
            
            CbrDescription description = new CbrDescription();
            description.setCount(new Instance("tt_1"));
            description.setDanger(new Instance("I_class"));
            description.setState(new Instance("as_1"));
            description.setTime(new Instance("fdt_1"));
            description.setTypes(new Instance("Журналы"));
            
            CBRQuery query = new CBRQuery();
            query.setDescription(description);
            app.cycle(query);
            CBRCase c = app.result();
            CbrSolution cd = (CbrSolution) c.getSolution();
            return result = cd.getResult().toString();
            
        } catch (ExecutionException | OntologyAccessException ex) {
            Logger.getLogger(CbrApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
