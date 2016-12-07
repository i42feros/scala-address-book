package domain.questions

import domain.{Human, Sex}
import org.scalatest.{Matchers, WordSpec}
import utils.DateUtils._
import utils.DateImplicits._

class DaysOlderThanSpec extends WordSpec with Matchers {

  "OlderThan" should {
    "get question" in new Context {
      daysOlderThan.question should be("How many days older is Bill than Paul?")
    }

    "get the answer found for first matching naming" when {
      "both has same date of birth" in new Context {
        val humans = Seq(
          Human("Bill McKnight", Sex.Male, parseDate("16/03/77")),
          Human("Paul Robinson", Sex.Male, parseDate("16/03/77")),
          Human("Jonas McKnight", Sex.Male, parseDate("16/03/77"))
        )

        val answer = daysOlderThan.answer(humans)

        answer should be(Some(0))
      }

      "Bill is older than Paul" in new Context {
        val humans = Seq(
          Human("Bill McKnight", Sex.Male, parseDate("16/03/77")),
          Human("Paul Robinson", Sex.Male, parseDate("16/04/77")),
          Human("Jonas McKnight", Sex.Male, parseDate("16/03/77"))
        )

        val answer = daysOlderThan.answer(humans)

        answer should be(Some(30))
      }

      "Bill is younger than Paul" in new Context {
        val humans = Seq(
          Human("Bill McKnight", Sex.Male, parseDate("17/03/77")),
          Human("Paul Robinson", Sex.Male, parseDate("16/03/77")),
          Human("Jonas McKnight", Sex.Male, parseDate("16/03/77"))
        )

        val answer = daysOlderThan.answer(humans)

        answer should be(Some(-1))
      }

      "more than 2 humans called Bill and Paul" in new Context {
        val humans = Seq(
          Human("Bill McKnight", Sex.Male, parseDate("16/03/77")),
          Human("Paul Robinson", Sex.Male, parseDate("17/03/77")),
          Human("Bill White", Sex.Male, parseDate("14/03/77")),
          Human("Paul White", Sex.Male, parseDate("15/03/77"))
        )

        val answer = daysOlderThan.answer(humans)

        answer should be(Some(1))
      }

    }

    "get None answer" when {
      "Any of the human is not found" in new Context {
        val humans = Seq(
          Human("Bill McKnight", Sex.Male, parseDate("16/03/77")),
          Human("Jonas McKnight", Sex.Male, parseDate("16/03/77"))
        )

        val answer = daysOlderThan.answer(humans)

        answer should be(None)
      }

      "Both of the humans are not found" in new Context {
        val humans = Seq(
          Human("Jonas McKnight", Sex.Male, parseDate("16/03/77"))
        )

        val answer = daysOlderThan.answer(humans)

        answer should be(None)
      }
    }
  }

  trait Context {
    val name1 = "Bill"
    val name2 = "Paul"
    val daysOlderThan = DaysOlderThan(name1, name2)
  }

}
