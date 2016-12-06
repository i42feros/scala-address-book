package service

import org.scalatest.{Matchers, WordSpec}


class HumanQuestionsServiceSpec extends WordSpec with Matchers {

  "HumanQuestionsService" should {

    "has the following questions" in {
      val filePath = getClass.getResource("/friends.txt").getPath

      val humanQuestionsService = new HumanQuestionsService(filePath)

      val (questions, answers) = humanQuestionsService.questions.unzip( questionAnswers =>
        (questionAnswers.question, questionAnswers.answer(humanQuestionsService.data)))

      questions should be(Seq(
        s"How many males are in the address book?"
      ))

      answers should be(Seq(
        1
      ))
    }

  }
}
