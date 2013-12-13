package controllers

import play.api._
import play.api.mvc._
import scala.io.Source
import models._
import scala.reflect.io.Path

object Application extends Controller {

  def index = Action {

    val array = new DangerClassArray

    array.readFile("dclass_result.json")

    Ok(views.html.index("Your new application is ready.", array.getList, getAggregateState))
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
   * @param value Содержимое bat файла.
   */
  def writeBatFile (value : String) = {

    Path("run.bat").toFile.writeAll(value)
  }

}