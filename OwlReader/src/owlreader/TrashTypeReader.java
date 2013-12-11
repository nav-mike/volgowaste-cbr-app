package owlreader;

import com.hp.hpl.jena.ontology.OntModel;

/**
 * Класс чтения типов отходов из owl.
 * @author M. Navrotskiy.
 * @version 1.0.
 */
public class TrashTypeReader {
    
    /* Поля класса. */
    
    /** SPARQL запрос на получение списка отходов из owl. */
    private final String request = "SELECT ?entity\n" +
                                            "WHERE {\n" +
                                            "  ?entity a ?type.\n" +
                                            "  ?type rdfs:subClassOf* <http://VolgoWaste.owl#Отход>.\n" +
                                            "}";
    
    /** Модель онтологии. */
    private OntModel owlModel = null;
    
    /** Имя файла с онтологией. */
    private final String filename = "VolgoWaste.owl";
    
}
