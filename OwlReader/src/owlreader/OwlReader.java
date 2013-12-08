package owlreader;

import java.util.ArrayList;

/**
 * Главный класс приложения - чтения owl.
 * @author M. Navrotskiy
 * @version 1.0
 */
public class OwlReader {

    /**
     * Главная функция приложения.
     * @param args Аргументы коммандной строки.
     */
    public static void main(String[] args) {
        // TODO текст приложения
        DangerClassReader dcr = new DangerClassReader();
        
        ArrayList arrayList = dcr.execQuery();
        
        DangerClassResultArray dcra = new DangerClassResultArray(arrayList);
        
        System.out.println(dcra.toString());
    }
    
}
