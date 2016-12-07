package domain.questions


import domain.Human
import utils.DateImplicits._


object OldestHuman extends QuestionAnswer[Human, Human] {
  override val question = s"Who is the oldest person in the address book?"

  override def answer(data: Seq[Human]): Human = data.minBy(_.dateOfBirth)
}
