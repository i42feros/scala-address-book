package utils

import domain.{Human, Sex}
import org.scalatest.{Matchers, WordSpec}
import DateUtils._

class PersonFileParserSpec extends WordSpec with Matchers {

  "PersonFileParser" should {

    "parseFile into Person objects" when {
      "is not an empty file" in {
        val filePath = getClass.getResource("/friends.txt").getPath

        val peopleRead = PersonFileParser.parseFile(filePath)

        peopleRead should be(List(
          Human("Bill McKnight", Sex.Male, parseDate("16/03/77").get),
          Human("Silvie Robinson", Sex.Female, parseDate("15/01/85").get)
        ))
      }

      "is an empty file" in {
        val filePath = getClass.getResource("/empty.txt").getPath

        val peopleRead = PersonFileParser.parseFile(filePath)

        peopleRead should be(List())
      }
    }

    "parseFile and ignore invalid Person objects" in {
      val filePath = getClass.getResource("/friends_some_invalid_format.txt").getPath

      val peopleRead = PersonFileParser.parseFile(filePath)

      peopleRead should be(List(
        Human("Silvie Robinson", Sex.Female, parseDate("15/01/85").get)
      ))
    }
  }
}
