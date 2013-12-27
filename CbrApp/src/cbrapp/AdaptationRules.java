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
        Case c = new Case(values[0], values[1], values[2], values[3], values[4]);
        System.out.println(c.toString());
        
        rule1(c);
        rule3(c);
        rule4(c);
        rule5(c);
        rule6(c);
        rule9(c);
        rule8(c);
        rule7(c);
        rule2(c);
        rule10(c);
        
        System.out.println(c.toString());
        return result = c.toStringArray();
    }
    
    /**
     * Правило №8:
     * ЕСЛИ тип = («Журналы» ИЛИ «Картонная_упаковка» ИЛИ «Книги» ИЛИ «Листовки») ТОГДА тип := «Макулатура»
     * @param c Прецедент с параметрами.
     */
    private static void rule8 (Case c) {
        
        if (c.getType().equals("Журналы") || c.getType().equals("Картонная_упаковка") ||
                c.getType().equals("Книги") || c.getType().equals("Листовки")) {
            
            c.setType("Макулатура");
        }
    }
    
    /**
     * Правило №10:
     * ЕСЛИ тип = («Бутылки_из_под_напитков» ИЛИ «Линолеум» ИЛИ «Водопроводная_труба» 
     * ИЛИ «Музыкальные_пластинки» ИЛИ «Корпус_лодки») ТОГДА класс опасности := «III_class»
     * @param c Прецедент.
     */
    private static void rule10 (Case c) {
        
        if (c.getType().equals("Бутылки_из_под_напитков") ||
                c.getType().equals("Линолеум") ||
                c.getType().equals("Водопроводная_труба") ||
                c.getType().equals("Музыкальные_пластинки") ||
                c.getType().equals("Корпус_лодки")) {
            
            c.setDanger("III_class");
        }
    }
    
    /**
     * Правило №1:
     * ЕСЛИ тип = («Батарейки» ИЛИ «Сотовые_телефоны») ТОГДА тип:= «Аккумуляторы_свинцовые_отработанные_и_брак»
     * @param c Прецедент.
     */
    private static void rule1 (Case c) {
        
        if (c.getType().equals("Батарейки") ||
                c.getType().equals("Сотовые_телефоны")) {
            
            c.setType("Аккумуляторы_свинцовые_отработанные_и_брак");
        }
    }
    
    /**
     * Правило №2:
     * ЕСЛИ тип = («Пиломатериалы» ИЛИ «Бумага» ИЛИ «Книги» ИЛИ «Журналы» ИЛИ «Макулатура») ТОГДА тип:= «Опилки_натуральной_чистой_древесины»
     * @param c Прецедент.
     */
    private static void rule2 (Case c) {
        
        if (c.getType().equals("Пиломатериалы") ||
                c.getType().equals("Бумага") ||
                c.getType().equals("Книги") ||
                c.getType().equals("Журналы") ||
                c.getType().equals("Макулатура")) {
            
            c.setType("Опилки_натуральной_чистой_древесины");
        }
    }
    
    /**
     * Правило №3:
     * ЕСЛИ тип = («Сандвич_панель») ТОГДА тип := «Отходы_рубероида»
     * @param c Прецедент.
     */
    private static void rule3 (Case c) {
        
        if (c.getType().equals("Сандвич_панель")) {
            
            c.setType("Отходы_рубероида");
        }
    }
    
    /**
     * Правило №4:
     * ЕСЛИ тип = («Пищевые_отходы») ТОГДА тип := «Отходы_из_жироотделителей
     * @param c Прецедент.
     */
    private static void rule4 (Case c) {
        
        if (c.getType().equals("Пищевые_отходы")) {
            
            c.setType("Отходы_из_жироотделителей");
        }
    }
    
    /**
     * Правило №5:
     * ЕСЛИ тип = («Отходы_рубероида») И количество = («от_500_тыс_до_1_млн» ИЛИ
     * «от_100_до_200_тыс») ТОГДА количество := «от_200_тыс_до_500_тыс»
     * @param c Прецедент.
     */
    private static void rule5 (Case c) {
        
        if (c.getType().equals("Отходы_рубероида")) {
            
            if (c.getCount().equals("от_500_тыс_до_1_млн") ||
                    c.getCount().equals("от_100_до_200_тыс")) {
                
                c.setCount("от_200_тыс_до_500_тыс");
            }
        }
    }
    
    /**
     * Правило №6:
     * ЕСЛИ тип = («Отходы_асфальтобетона_и_асфальтобетонной_смеси» ИЛИ «Отходы_из_жироотделителей») ТОГДА количество := «от_1_до_5_млн»
     * @param c Прецедент.
     */
    private static void rule6 (Case c) {
        
        if (c.getType().equals("Отходы_асфальтобетона_и_асфальтобетонной_смеси") ||
                c.getType().equals("Отходы_из_жироотделителей")) {
            
            c.setCount("от_1_до_5_млн");
        }
    }
    
    /**
     * Правило №7:
     * ЕСЛИ тип = («Золошлаки_от_сжигания_углей») И количество = («до_100_тыс» ИЛИ
     * «от_100_до_200_тыс» ИЛИ «от_200_тыс_до_500_тыс») ТОГДА количество := «до_100_тыс»
     * @param c Прецедент.
     */
    private static void rule7 (Case c) {
        
        if (c.getType().equals("Золошлаки_от_сжигания_углей")) {
            
            if (c.getCount().equals("до_100_тыс") ||
                    c.getCount().equals("от_100_до_200_тыс") ||
                    c.getCount().equals("от_200_тыс_до_500_тыс")) {
                
                c.setCount("до_100_тыс");
            }
        }
    }
    
    /**
     * Правило №9:
     * ЕСЛИ тип = («Журналы» ИЛИ «Картонная_упаковка» ИЛИ «Книги» ИЛИ «Листовки») ТОГДА класс опасности := «V_class»
     * @param c Прецедент.
     */
    private static void rule9 (Case c) {
        
        if (c.getType().equals("Журналы") || c.getType().equals("Картонная_упаковка") ||
                c.getType().equals("Книги") || c.getType().equals("Листовки")) {
            
            c.setDanger("V_class");
        }
    }
    
    /**
     * Класс прецедента.
     * @author M. Navrotskiy
     * @version 1.0
     */
    public static class Case {
        
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
