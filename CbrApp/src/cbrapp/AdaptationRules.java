package cbrapp;

/**
 * Класс правил адаптации.
 * @author M. Navrotskiy.
 * @version 1.0
 */
public class AdaptationRules {
    
    /**
     * Метод применения правил адаптации.
     * @param values Параметры прецедента.
     * @return Параметры прецедента после адаптации.
     */
    public static String[] useRules (String[] values) {
        String[] result = new String[5];
        
        return result;
    }
    
    /**
     * Класс прецедента.
     * @author M. Navrotskiy
     * @version 1.0
     */
    public class Case {
        
        /* Поля класса. */
        /** Количество отходов. */
        private String count;
        /** Класс опасности отходов. */
        private String danger;
        /** Агрегатное состояние отходов. */
        private String state;
        /** Время полного разложения отходов. */
        @Deprecated
        private String time;
        /** Тип отходов. */
        private String type;
        
    }
    
}
