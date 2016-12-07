package domain.questions

import domain.{Human, Sex}
import org.scalatest.{Matchers, WordSpec}
import utils.DateUtils._


class OldestHumanSpec extends WordSpec with Matchers {

  "OldestHuman" should {
    "get question" in {
      OldestHuman.question should be("Who is the oldest person in the address book?")
    }

    "get answer" in {
      val humans = Seq(
        Human("Bill McKnight", Sex.Male, parseDate("16/03/77").get),
        Human("Silvie Robinson", Sex.Female, parseDate("15/01/85").get),
        Human("Jonas McKnight", Sex.Male, parseDate("17/03/77").get)
      )

      val answer = OldestHuman.answer(humans)

      answer should be(Human("Bill McKnight", Sex.Male, parseDate("16/03/77").get))
    }

  }



}
