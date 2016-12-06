package utils

import java.time.LocalDateTime

import domain.{Human, Sex}
import org.scalatest.{Matchers, WordSpec}

class PersonFileParserSpec extends WordSpec with Matchers {

  "PersonFileParser" should {

    "parseFile into Person objects" when {
      "is not an empty file" in {
        val filePath = getClass.getResource("/friends.txt").getPath

        val peopleRead = PersonFileParser.parseFile(filePath)

        peopleRead should be(List(
          Human("Bill McKnight", Sex.Male, LocalDateTime.parse("16/03/77")),
          Human("Silvie Robinson", Sex.Female, LocalDateTime.parse("15/01/85"))
        ))
      }

      "is an empty file" in {
        val filePath = getClass.getResource("/empty.txt").getPath

        val peopleRead = PersonFileParser.parseFile(filePath)

        peopleRead should be(List())
      }
    }

    "parseFile and ignore invalid Person objects" in {
      val filePath = getClass.getResource("/friends.txt").getPath

      val peopleRead = PersonFileParser.parseFile(filePath)

      peopleRead should be(List(
        Human("Silvie Robinson", Sex.Female, LocalDateTime.parse("15/01/85"))
      ))
    }
  }
}
