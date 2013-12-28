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
 * Главный класс приложения.
 * @author M. Navrotskiy
 * @version 1.0
 */
public class CbrApp {
    
    public static CbrSolution lastCase = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if (args.length == 0) {
            MainWindow mainWindow = 
                    new MainWindow("http://www.owl-ontologies.com/vw_cbr.owl#");
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
    public static void writeResult (ArrayList<String> result) {
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
     * @param values Значение, введенное пользователем.
     * @return Результат CBR анализа.
     */
    public static String cbr (String[] values) {
        try {
            String result = "";
            CbrApplication app = new CbrApplication();
            app.configure();
            app.preCycle();
            
            CbrDescription description = new CbrDescription();
            description.setCount(new Instance(values[0]));
            description.setDanger(new Instance(values[1]));
            description.setState(new Instance(values[2]));
            description.setTime(new Instance(values[3]));
            description.setTypes(new Instance(values[4]));
            
            CBRQuery query = new CBRQuery();
            query.setDescription(description);
            app.cycle(query);
            CBRCase c = app.result();
            CbrSolution cd = (CbrSolution) c.getSolution();
            lastCase = cd;
            return result = cd.getResult().toString();
            
        } catch (ExecutionException | OntologyAccessException ex) {
            Logger.getLogger(CbrApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
