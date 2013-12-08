package models

import scala.io.Source
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Класс списка классов опасности.
 */
class DangerClassArray() {

  /* Поля класса. */
  /** Список классов опасности. */
  private var array : List[DangerClassItem] = List()

  /**
   * Метод получения списка классов опасности.
   * @return Список классов опасности.
   */
  def getList = {
    this.array
  }

  /**
   * Метод чтения списка из файла.
   * @param filename Имя файла.
   */
  def readFile (filename : String) = {

    val strings = Source.fromFile(filename).getLines().toArray

    import java.{util => ju}
    import scala.collection.JavaConverters._

    val gson = new Gson
    val resultType = new TypeToken[ju.ArrayList[DangerClassItem]] {}.getType
    val result = gson.fromJson[ju.ArrayList[DangerClassItem]](strings(0), resultType).asScala

    this.array = result.toList
  }

}
