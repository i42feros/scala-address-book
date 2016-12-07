package service

import domain.{Human, Sex}
import org.scalatest.{Matchers, WordSpec}
import utils.DateUtils._
import utils.DateImplicits._


class HumanQuestionsServiceSpec extends WordSpec with Matchers {

  "HumanQuestionsService" should {
    "has the suggested questions" when {

      "using a simple file of data set" in {

        val filePath = getClass.getResource("/friends.txt").getPath

        val humanQuestionsService = new HumanQuestionsService(filePath)

        val (questions, answers) = humanQuestionsService.questions.unzip(questionAnswers =>
          (questionAnswers.question, questionAnswers.answer(humanQuestionsService.data)))

        questions should be(Vector(
          "How many males are in the address book?",
          "Who is the oldest person in the address book?",
          "How many days older is Bill than Paul?"
        ))

        answers should be(Vector(
          1,
          Human("Wes Jackson", Sex.Male, parseDate("14/08/74")),
          None
        ))
      }

      "using the original file data set" in {
        val filePath = getClass.getResource("/AddressBook").getPath

        val humanQuestionsService = new HumanQuestionsService(filePath)

        val (questions, answers) = humanQuestionsService.questions.unzip(questionAnswers =>
          (questionAnswers.question, questionAnswers.answer(humanQuestionsService.data)))

        questions should be(Vector(
          "How many males are in the address book?",
          "Who is the oldest person in the address book?",
          "How many days older is Bill than Paul?"
        ))

        answers should be(Vector(
          3,
          Human("Bill McKnight", Sex.Male, parseDate("16/03/77")),
          Some(2862)
        ))
      }
    }
  }
}
