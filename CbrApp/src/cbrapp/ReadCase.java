package cbrapp;

import es.ucm.fdi.gaia.ontobridge.OntoBridge;
import java.util.Iterator;
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
        
        // count
        result[0] = getParam(uri, bridge, "count");
        
        // danger
        result[1] = getParam(uri, bridge, "danger");
        
        // state
        result[2] = getParam(uri, bridge, "state");
        
        // time
        result[3] = getParam(uri, bridge, "time");
        
        // type
        result[4] = getParam(uri, bridge, "types");
        
        return result;
    }
    
    /**
     * Метод получения значения параметра прецедента из онтологии.
     * @param uri URI прецедента.
     * @param bridge Объект модели онтологии.
     * @param paramName Название параметра в онтологии.
     * @return Значение параметра прецедента из онтологии.
     */
    private static String getParam (String uri, OntoBridge bridge, String paramName) {
        String result = "";
        
        Iterator it = bridge.listPropertyValue(uri, paramName);
        
        while (it.hasNext()) {
            
            String item = it.next().toString();
            
            result = item.substring(item.indexOf("#") + 1, item.length());
            
            System.out.println(item);
        }
        
        return result;
    }
    
}
