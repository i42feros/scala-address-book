package domain.questions

import java.time.LocalDate

import domain.Human


case class DaysOlderThan(humanName1: String, humanName2: String) extends QuestionAnswer[Human, Option[Long]] {
  override val question = s"How many days older is $humanName1 than $humanName2?"

  override def answer(data: Seq[Human]): Option[Long] = {
    val maybeHuman1 = data.find(_.fullName.startsWith(humanName1))
    val maybeHuman2 = data.find(_.fullName.startsWith(humanName2))

    for {
      human1 <- maybeHuman1
      human2 <- maybeHuman2
    } yield getDaysBetweenDates(human1.dateOfBirth, human2.dateOfBirth)
  }

  override def answerToString(data: Seq[Human]): String = answer(data).map(days => s"$days days older")
    .getOrElse("Error getting a result")

  private def getDaysBetweenDates(date1: LocalDate, date2: LocalDate): Long = {
    date2.toEpochDay - date1.toEpochDay
  }

}
