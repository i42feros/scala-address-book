package utils

import java.util.Date

import domain.{Human, Sex}
import DateUtils._

import scala.io.Source


object PersonFileParser extends FileParser[Human] {
  private val Columns = 3
  private val FullNameColumnIndex = 0
  private val SexColumnIndex = 1
  private val DateColumnIndex = 2

  override def parseFile(filePath: String): List[Human] = {
    val fileLines = Source.fromFile(filePath).getLines
    fileLines.flatMap { line =>
      val columns = line.split(",").map(_.trim)
      if (columns.length != Columns) {
        println(s"Unexpected number of columns")
        None
      } else {
        getColumnValues(columns)
      }
    }.toList
  }

  private def getColumnValues(columns: Array[String]): Option[Human] = {
    val fullName: String = columns(FullNameColumnIndex)
    val maybeSex = Sex.valueOf(columns(SexColumnIndex))
    val dateParsed: Either[String, Date] = parseDate(columns(DateColumnIndex))

    dateParsed match {
      case Right(_) if maybeSex.isEmpty =>
        println(s"Sex not found at line: $columns")
        None
      case Right(_) if fullName.isEmpty =>
        println(s"Empty name not allowed at line: $columns")
        None
      case Left(errorMessage) =>
        println(s"Invalid format date at line: $columns, error: $errorMessage")
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
