package utils

import java.text.SimpleDateFormat
import java.util.Date

import scala.util.Try

object DateUtils {
  private val dateFormatter = new SimpleDateFormat("dd/MM/yy")

  // TODO: Will be more useful return the error message if it fails
  def parseDate(dateStr: String): Option[Date] =
    Try(dateFormatter.parse(dateStr)).toOption
}
