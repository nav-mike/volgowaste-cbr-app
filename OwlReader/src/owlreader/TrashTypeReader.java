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
    
    /**
     * Конструктор по умолчанию.
     */
    public TrashTypeReader() {
        this.owlModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        this.owlModel.read(this.filename, "RDF/XML-ABBREV");
    }
    
    /**
     * Метод чтения типов отходов из онтологии.
     * @return Список типов отходов из онтологии.
     */
    public ArrayList execQuery() {
        
        ArrayList result = new ArrayList();
        
        Query query = QueryFactory.create(this.request);
        QueryExecution qexec = QueryExecutionFactory.create(query, this.owlModel);
        ResultSet results = qexec.execSelect();
        
        while (results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            RDFNode x = solution.get("entity");
            String name = x.toString();
            
            result.add(name);
        }
        
        return result;
    }
    
}
