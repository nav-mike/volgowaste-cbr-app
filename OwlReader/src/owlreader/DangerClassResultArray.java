package owlreader;

import java.util.ArrayList;

/**
 * Класс списка классов опасности из онтологии.
 * @author M. Navrotskiy
 * @version 1.0
 */
public class DangerClassResultArray {
    
    /* Поля класса. */
    /** Список классов опасности из онтологии. */
    private ArrayList<DangerClassResult> array;

    /**
     * Конструктор по умолчанию.
     */
    public DangerClassResultArray() {
        this.array = new ArrayList<>();
    }
    
    /**
     * Конструктор с параметром.
     * @param strings Список классов опасности из онтологии.
     */
    public DangerClassResultArray (ArrayList<String> strings) {
        
        this.array = new ArrayList<>();
        
        for (String item : strings) {
            this.array.add(new DangerClassResult(item));
        }
    }
    
}
