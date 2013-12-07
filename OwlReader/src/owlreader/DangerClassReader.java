package owlreader;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import java.util.ArrayList;

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
    
    /**
     * Конструктор по умолчанию.
     */
    public DangerClassReader() {
        this.owlModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        this.owlModel.read(this.filename, "RDF/XML-ABBREV");
    }
    
    /**
     * Метод чтения классов опасности из онтологии.
     * @return Список классов опасности.
     */
    public ArrayList<String> execQuery() {
        ArrayList result = new ArrayList();
        
        Query query = QueryFactory.create(this.request);
        QueryExecution qexec = QueryExecutionFactory.create(query, this.owlModel);
        ResultSet results = qexec.execSelect();
        
        while (results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            RDFNode x = solution.get("object");
            String name = x.toString();
            
            result.add(name);
        }
        
        return result;
    }
    
}
