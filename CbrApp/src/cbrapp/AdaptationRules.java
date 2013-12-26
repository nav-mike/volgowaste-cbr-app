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
        
        /**
         * Конструктор по умолчанию.
         */
        protected Case () {}

        /**
         * Конструктор с параметрами.
         * @param count Количество отходов.
         * @param danger Класс опасности.
         * @param state Агрегатное состояние.
         * @param time Время полного разложения.
         * @param type Тип отходов.
         */
        public Case(String count, String danger, String state, String time, String type) {
            this.count = count;
            this.danger = danger;
            this.state = state;
            this.time = time;
            this.type = type;
        }
        
    }
    
}
