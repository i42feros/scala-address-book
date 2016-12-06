package utils

trait FileParser[T] {
  def parseFile(filePath: String): List[T]
}
