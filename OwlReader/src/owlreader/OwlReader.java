package owlreader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        parseArgs(args);
    }
    
    /**
     * Метод парсинга параметров командной строки.
     * @param args Параметры командной строки.
     */
    private static void parseArgs (String[] args) {
        
        if (args.length != 1)
            System.exit(1);
        
        if (args[0].equals("-dc"))
            readDangerClasses();
        
        if (args[0].equals("-tt"))
            readTrashTypes();
    }
    
    /**
     * Метод чтения классов опасности из owl.
     */
    private static void readDangerClasses() {
        
        DangerClassReader dcr = new DangerClassReader();
        
        ArrayList arrayList = dcr.execQuery();
        
        DangerClassResultArray dcra = new DangerClassResultArray(arrayList);
        
        writeDangerClassesToFile(dcra, "dclass_result.json");
    }
    
    /**
     * Метод чтения типов отходов из owl.
     */
    private static void readTrashTypes() {
        
        TrashTypeReader ttr = new TrashTypeReader();
        
        ArrayList list = ttr.execQuery();
        
        TrashTypeResultArray ttra = new TrashTypeResultArray(list);
        
        writeDangerClassesToFile(ttra, "ttype_result.json");
    }
    
    /**
     * Метод записи списка классов опасности в файл.
     * @param array Список классов опасности.
     * @param filename Имя файла.
     */
    private static void writeDangerClassesToFile (DangerClassResultArray array, 
            String filename) {
        try {
            File file = new File(filename);
            
            FileWriter writer = new FileWriter(file);
            
            writer.write(array.toString());
            
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(OwlReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
