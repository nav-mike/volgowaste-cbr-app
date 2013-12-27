package cbrapp;

import es.ucm.fdi.gaia.ontobridge.OntoBridge;
import jcolibri.util.OntoBridgeSingleton;

/**
 * Класс чтения прецедента из базы.
 * @author M. Navrotskiy
 * @version 1.0
 */
public class ReadCase {
    
    /**
     * Метод чтения параметров прецедента из онтологии.
     * @param uri URI прецедента в онтологии.
     * @return Массив с параметрами прецедента.
     */
    public static String[] getParams (String uri) {
        
        String[] result = new String[5];
        OntoBridge bridge = OntoBridgeSingleton.getOntoBridge();
        
        return result;
    }
    
}
