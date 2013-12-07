package owlreader;

import com.hp.hpl.jena.ontology.OntModel;

/**
 * Класс чтения классов опасности отходов.
 * @author M. Navrotskiy
 * @version 1.0
 */
public class DangerClassReader {
    
    /* Поля класса. */
    /** SPARQL запрос на получение классов опасности. */
    private final String request = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
            "SELECT ?subject ?object\n" +
            "	WHERE { ?subject rdf:type <http://VolgoWaste.owl#Класс_опасности> }";
    
    /** Модель онтологии. */
    private OntModel owlModel = null;
    
    /** Имя файла с онтологией. */
    private final String filename = "VolgoWaste.owl";
    
}
