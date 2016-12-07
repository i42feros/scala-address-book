package service

import domain.questions.{CountBySex, DaysOlderThan, OldestHuman}
import domain.{Human, Sex}
import utils.HumanFileParser


class HumanQuestionsService(filePath: String) extends ReplyQuestionsService[Human](HumanFileParser)(filePath) {
  private val nameHuman1 = "Bill"
  private val nameHuman2 = "Paul"
  override val questions = Vector(
    CountBySex(Sex.Male),
    OldestHuman,
    DaysOlderThan(nameHuman1, nameHuman2))
}
