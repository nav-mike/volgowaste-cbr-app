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

}
