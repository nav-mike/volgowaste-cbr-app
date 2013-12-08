package models

/**
 * Класс класса опасности.
 * @param iid Идентификатор в онтологии.
 * @param ivalue Значение.
 */
class DangerClassItem(iid : String, ivalue : String) {

  /** Идентификатор класс опасности в онтологии. */
  private var id : String = iid

  /** Значение класс опасности в онтологии. */
  private var value : String = ivalue

  /**
   * Метод получения значения идентификатора класса опасности.
   * @return Значение идентификатора класса опасности.
   */
  def getId : String = {
    this.id
  }

  /**
   * Метод изменения значения идентификатора класса опасности.
   * @param id Значение идентификатора класса опасности.
   */
  def setId (id : String) = {
    this.id = id
  }

  /**
   * Метод получения значения класса опасности.
   * @return Значение класса опасности.
   */
  def getValue : String = {
    this.value
  }

  /**
   * Метод изменения значения класса опасности.
   * @param value Значение класса опасности.
   */
  def setValue (value : String) = {
    this.value = value
  }

}
