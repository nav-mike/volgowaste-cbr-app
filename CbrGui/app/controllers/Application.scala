package controllers

import play.api._
import play.api.mvc._
import scala.io.Source

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
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

}