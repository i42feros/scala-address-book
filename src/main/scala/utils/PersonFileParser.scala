package utils

import domain.{Human, Sex}
import DateUtils._

import scala.io.Source
import scala.util.Try


object PersonFileParser extends FileParser[Human] {

  override def parseFile(filePath: String): List[Human] = {
    val fileLines = Source.fromFile(filePath).getLines
    fileLines.flatMap {line =>
      val columns = line.split(",").map(_.trim)
      Try(
        Human(
          columns(0),
          Sex.valueOf(columns(1)).get,
          parseDate(columns(2)).get)
      ).toOption
      // TODO display some error message if it does not match format
    }.toList
  }
}
