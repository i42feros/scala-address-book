package utils

import java.time.LocalDate

import domain.{Human, Sex}
import utils.DateUtils._


object HumanFileParser extends FileParser[Human] {
  override protected val ColumnSeparator = ","
  override protected val Columns: Integer = 3
  private val FullNameColumnIndex = 0
  private val SexColumnIndex = 1
  private val DateColumnIndex = 2

  override protected def getColumnValues(columns: Array[String]): Option[Human] = {
    val fullName: String = columns(FullNameColumnIndex)
    val maybeSex = Sex.valueOf(columns(SexColumnIndex))
    val dateParsed: Either[String, LocalDate] = parseDate(columns(DateColumnIndex))

    dateParsed match {
      case Right(_) if maybeSex.isEmpty =>
        println(s"Sex not found at line: ${columns.mkString(",")}")
        None
      case Right(_) if fullName.isEmpty =>
        println(s"Empty name not allowed at line: ${columns.mkString(",")}")
        None
      case Left(errorMessage) =>
        println(s"Invalid format date at with: ${columns(DateColumnIndex)}, error: $errorMessage")
        None
      case Right(date) if maybeSex.isDefined && fullName.nonEmpty =>
        Some(
          Human(
            fullName,
            maybeSex.get,
            date))
    }
  }

}
