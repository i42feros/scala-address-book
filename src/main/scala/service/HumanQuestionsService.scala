package service

import domain.questions.{CountBySex, QuestionAnswer}
import domain.{Human, Sex}
import utils.PersonFileParser


class HumanQuestionsService(filePath: String) extends ReplyQuestionsService[Human](PersonFileParser)(filePath) {
  override val questions: Seq[_ <: QuestionAnswer[Human,_ <: Any]] = Seq(CountBySex(Sex.Male))
}
