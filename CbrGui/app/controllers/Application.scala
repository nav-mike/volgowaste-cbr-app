package controllers

import play.api._
import play.api.mvc._
import scala.io.Source
import models._
import scala.reflect.io.Path

object Application extends Controller {

  def index = Action {

    getDangerType

    val array = new DangerClassArray

    array.readFile("dclass_result.json")

    val types = new DangerClassArray

    types.readFile("ttype_result.json")

    Ok(views.html.index("Your new application is ready.", array.getList, getAggregateState, types.getList))
  }

  /**
   * Метод вывода результата CBR.
   * @return Страница - результат CBR.
   */
  def getCbrResult = Action {
    val cbr = readResultFile

    Ok(views.html._result(cbr))
  }

  /**
   * Метод чтения результирующего файла.
   * @return Список результатов CBR.
   */
  def readResultFile : List[String] = {
    val result = Source.fromFile("result.txt").getLines().toList

    result
  }

  /**
   * Метод формирование списка агрегатных состояний.
   * @return Список агрегатных состояний.
   */
  def getAggregateState : List[String] = {
    var result = List[String]()

    result = "Твердое" :: result
    result = "Жидкое" :: result
    result = "Газообразное" :: result

    result
  }

  /**
   * Метод записи .bat файла для читалки owl.
   * @param arg Содержимое bat файла.
   */
  def writeBatFile (arg : String) = {

    Path("run.bat").toFile.writeAll("java -jar OwlReader.jar " + arg)
  }

  /**
   * Метод вызова читалки owl для получения классов опасности.
   */
  def getDangerType = {

    writeBatFile("-dc")

    val builder = new ProcessBuilder("run.bat")
    builder.redirectErrorStream(true)

    val process = builder.start()
  }

  /**
   * Метод вызова читалки owl для получения типов отходов.
   */
  def getTrashType = {

    writeBatFile("tt")

    val builder = new ProcessBuilder("run.bat")

    val process = builder.start()
  }

}