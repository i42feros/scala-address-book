package domain.questions

import domain.{Human, Sex}
import org.scalatest.{Matchers, WordSpec}
import utils.DateUtils._

class CountBySexSpec extends WordSpec with Matchers {

  "CountBySex" should {
    "get question" in new Context {
      countMales.question should be("How many males are in the address book?")
    }

    "get answer" in new Context {
      val humans = Seq(
        Human("Bill McKnight", Sex.Male, parseDate("16/03/77").get),
        Human("Silvie Robinson", Sex.Female, parseDate("15/01/85").get),
        Human("Jonas McKnight", Sex.Male, parseDate("16/03/77").get)
      )

      val answer = countMales.answer(humans)

      answer should be(2)
    }
  }

  trait Context {
    val countMales = CountBySex(Sex.Male)
  }

}
