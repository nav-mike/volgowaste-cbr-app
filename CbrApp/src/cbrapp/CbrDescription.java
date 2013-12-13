
package cbrapp;

import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CaseComponent;
import jcolibri.datatypes.Instance;

/**
 * Класс описания прецедента.
 * @author M. Navrotskiy
 */
public class CbrDescription implements CaseComponent {
    
    /* Поля класса. */
    /** Параметры прецедента. */
    private Instance params;
    /** Результат анализа. */
    private Instance result;
    /** Главный консепт. */
    private Instance mainConcept;

    /**
     * Метод изменения главного концепта.
     * @param mainConcept Новый главный концепт.
     */
    public void setMainConcept(Instance mainConcept) {
        this.mainConcept = mainConcept;
    }

    /**
     * Метод получения значения главного концепта.
     * @return Значение главного концепта.
     */
    public Instance getMainConcept() {
        return mainConcept;
    }

    /**
     * Метод преобразования в строку.
     * @return Значение всех полей класса в виде строки.
     */
    @Override
    public String toString() {
        return "[" + mainConcept + ":" + this.params + ";" + this.result + "]";
    }

    /**
     * Метод изменения значения результата цикла.
     * @param result Значение результата цикла.
     */
    public void setResult(Instance result) {
        this.result = result;
    }

    /**
     * Метод изменения значения параметров прецедента.
     * @param params Значение параметров прецедента.
     */
    public void setParams(Instance params) {
        this.params = params;
    }

    /**
     * Метод получения значения результатов цикла.
     * @return Значение результатов цикла.
     */
    public Instance getResult() {
        return result;
    }

    /**
     * Метод получения значения параметров прецедента.
     * @return Значение параметров прецедента.
     */
    public Instance getParams() {
        return params;
    }

    /**
     * Метод получения идентификатора атрибута.
     * @return Идентификатор атрибута.
     */
    @Override
    public Attribute getIdAttribute() {
        return new Attribute("mainConcept", this.getClass());
    }
    
}
