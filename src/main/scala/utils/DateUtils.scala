package utils

import java.text.SimpleDateFormat
import java.util.Date

import scala.util.{Failure, Success, Try}

object DateUtils {
  private val dateFormatter = new SimpleDateFormat("dd/MM/yy")

  def parseDate(dateStr: String): Either[String, Date] =
    Try(dateFormatter.parse(dateStr)) match {
      case Success(parsedValue) => Right(parsedValue)
      case Failure(error) => Left(error.toString)
    }
}
