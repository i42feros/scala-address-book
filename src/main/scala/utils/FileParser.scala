package utils


import scala.io.Source

trait FileParser[T] {
  protected def ColumnSeparator: String

  protected def Columns: Integer

  protected def getColumnValues(columns: Array[String]): Option[T]

  def parseFile(filePath: String): List[T] = {
    val fileLines = Source.fromFile(filePath).getLines
    fileLines.flatMap { line =>
      val columns = line.split(ColumnSeparator).map(_.trim)
      if (columns.length != Columns) {
        println(s"Unexpected number of columns at $line")
        None
      } else {
        getColumnValues(columns)
      }
    }.toList
  }


}
