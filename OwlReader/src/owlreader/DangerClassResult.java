package owlreader;

/**
 * Класс результата запроса классов опасности.
 * @author M. Navrotskiy
 * @version 1.0
 */
public class DangerClassResult {
    
    /* Поля класса. */
    /** Значение класса опасности. */
    private String value;
    
    /** Идентификатор класса опасности. */
    private String id;

    /**
     * Конструктор по умолчанию.
     */
    public DangerClassResult() {
        this.id = "";
        this.value = "";
    }
    
    /**
     * Конструктор с параметром.
     * Создает результат на основе строки с uri.
     * @param owlUri uri из онтологии.
     */
    public DangerClassResult (String owlUri) {
        
        this.id = owlUri;
        this.value = owlUri.substring(0, owlUri.indexOf("#"));
    }
    
}
