/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cbrapp;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
        System.out.println(args[0]);
        CbrApplication app = new CbrApplication();
        String cbrResult = cbr(args[0]);
        writeResult(cbrResult);
    }
    
    /**
     * Функция записи результата CBR в файл.
     * @param result Результат работы CBR.
     */
    private static void writeResult (String result) {
        try {
            PrintWriter out = new PrintWriter("result.txt");
            out.println(result);
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
    private static String cbr (String value) {
        try {
            String result = "";
            CbrApplication app = new CbrApplication();
            app.configure();
            app.preCycle();
            CbrDescription description = new CbrDescription();
            CBRQuery query = new CBRQuery();
            query.setDescription(description);
            app.cycle(query);
            CBRCase c = app.result();
            CbrDescription cd = (CbrDescription) c.getDescription();
            return result;
            
        } catch (ExecutionException ex) {
            Logger.getLogger(CbrApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
