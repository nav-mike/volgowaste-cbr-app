package cbrapp;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Преобразует запрос в uri экземпляра.
 * @author M. Navrotskiy
 * @version 1.0
 */
public class JenaReader {
    
    /**
     * Метод получения класса опасности из онтологии.
     * @param value Значение с gui.
     * @return Класс опасности с uri.
     */
    public static String getDangerClass (String value) {
        try {
            String result = "";
            
            OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(new FileInputStream("vw_cbr.owl"), "");
            
            OntClass danger = model.getOntClass("http://www.owl-ontologies.com/vw_cbr.owl#Danger");
            
            ExtendedIterator it = danger.listInstances();
            
            while (it.hasNext()) {
                Object item = it.next();
                
                if (item.toString().contains(getOwlDangerClass(value)))
                    System.out.println(item);
            }
            
            model.close();
            
            return result;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JenaReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Метод перевода класса опасности.
     * @param value Значение из gui.
     * @return Англоязычное значение.
     */
    private static String getOwlDangerClass (String value) {
        String result;
        
        if (value.matches("^IV_.*$")) {
            result = "IV_class";
        } else if (value.matches("^V_.*$")) {
            result = "V_class";
        } else if (value.matches("^III_.*$")) {
            result = "III_class";
        } else if (value.matches("^II_.*$")) {
            result = "II_class";
        } else {
            result = "I_class";
        }
        
        return result;
    }
    
}
