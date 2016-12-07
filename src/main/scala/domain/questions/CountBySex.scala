package domain.questions

import domain.{Human, Sex}


case class CountBySex(sex: Sex) extends QuestionAnswer[Human, Int] {
  override val question = s"How many ${sex.toString.toLowerCase}s are in the address book?"

  override def answer(data: Seq[Human]): Int = data.count(_.sex == sex)

  override def answerToString(data: Seq[Human]): String = answer(data).toString
}
