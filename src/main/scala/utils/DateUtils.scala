package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import scala.util.{Failure, Success, Try}

object DateUtils {
  private val DateFormatter = DateTimeFormatter.ofPattern("dd/MM/yy")

  def parseDate(dateStr: String): Either[String, LocalDate] =
    Try(LocalDate.parse(dateStr, DateFormatter)) match {
      case Success(parsedValue) => Right(parsedValue)
      case Failure(error) => Left(error.toString)
    }
}
