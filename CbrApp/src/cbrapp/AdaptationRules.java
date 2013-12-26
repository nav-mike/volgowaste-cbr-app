package cbrapp;

import com.google.gson.Gson;

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
         * Метод преобразования объекта в массив.
         * @return Массив прецедента.
         */
        public String[] toStringArray() {
            String[] result = new String[5];
            
            result[0] = this.count;
            result[1] = this.danger;
            result[2] = this.state;
            result[3] = this.time;
            result[4] = this.type;
            
            return result;
        }

        /**
         * Метод преобразования объекта (прецедента) в json строку.
         * @return json строка.
         */
        @Override
        public String toString() {
            Gson gson = new Gson();
            return gson.toJson(this);
        }

        /**
         * Метод изменения значения типа отходов.
         * @param type Значение типа отходов.
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * Метод изменения значения времени разложения.
         * @param time Значение времени разложения.
         */
        public void setTime(String time) {
            this.time = time;
        }

        /**
         * Метод изменения значения агрегатного состояния.
         * @param state Значение агрегатного состояния.
         */
        public void setState(String state) {
            this.state = state;
        }

        /**
         * Метод изменения значения класса опасности.
         * @param danger Значение класса опасности.
         */
        public void setDanger(String danger) {
            this.danger = danger;
        }

        /**
         * Метод изменения количества отходов.
         * @param count Значение количества отходов.
         */
        public void setCount(String count) {
            this.count = count;
        }

        /**
         * Метод получения значения типа отходов.
         * @return Значение типа отходов.
         */
        public String getType() {
            return type;
        }

        /**
         * Метод получения значения времени разложения.
         * @return Значение времени разложения.
         */
        @Deprecated
        public String getTime() {
            return time;
        }

        /**
         * Метод получения значения агрегатного состояния.
         * @return Значение агрегатного состояния.
         */
        public String getState() {
            return state;
        }

        /**
         * Метод получения значения класса опасности.
         * @return Значение класса опасности.
         */
        public String getDanger() {
            return danger;
        }

        /**
         * Метод получения значения количества отходов.
         * @return Значение количества отходов.
         */
        public String getCount() {
            return count;
        }
        
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
