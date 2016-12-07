package service

import domain.questions.{CountBySex, DaysOlderThan, OldestHuman, QuestionAnswer}
import domain.{Human, Sex}
import utils.PersonFileParser


class HumanQuestionsService(filePath: String) extends ReplyQuestionsService[Human](PersonFileParser)(filePath) {
  private val nameHuman1 = "Bill"
  private val nameHuman2 = "Paul"
  override val questions: Seq[_ <: QuestionAnswer[Human,_ <: Any]] = Seq(
    CountBySex(Sex.Male),
    OldestHuman,
    DaysOlderThan(nameHuman1, nameHuman2))
}
