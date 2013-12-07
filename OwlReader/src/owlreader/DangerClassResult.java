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
    
}
