package owlreader;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;

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
    
}
