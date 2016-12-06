package utils

import domain.Human


object PersonFileParser extends FileParser[Human] {
  override def parseFile(filePath: String): List[Human] = ???
}
