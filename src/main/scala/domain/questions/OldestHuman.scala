package domain.questions

import domain.Human


object OldestHuman extends QuestionAnswer[Human, Human] {
  override val question = s"Who is the oldest person in the address book?"

  override def answer(data: Seq[Human]): Human = data.reduceLeft {
    (min, person) => if (person.dateOfBirth.before(min.dateOfBirth)) person else min
  }
}
