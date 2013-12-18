package cbrapp;

import es.ucm.fdi.gaia.ontobridge.OntoBridge;
import java.util.ArrayList;
import java.util.Iterator;
import jcolibri.util.OntoBridgeSingleton;

/**
 * Класс чтения рекомендаций из онтологии.
 * @author M. Navrotskiy
 * @version 1.0
 */
public class ReadSolutions {
    
    /**
     * Метод получения значений рекомендаций из онтологии.
     * @param uri Выбранный экземпляр.
     * @return Список рекомендаций.
     */
    public static ArrayList<String> getSolutionsText (String uri) {
        
        ArrayList result = new ArrayList();
        
        OntoBridge bridge = OntoBridgeSingleton.getOntoBridge();
        
        Iterator it = bridge.listPropertyValue(uri, "solutionsValue");
        
        while (it.hasNext()) {
            
            String item = it.next().toString();
            result.add(item.substring(0, item.indexOf('^')));
        }
        
        return result;
    }
    
}
