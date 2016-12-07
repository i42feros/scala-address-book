package domain.questions

import java.util.Date

import domain.Human


case class DaysOlderThan(humanName1: String, humanName2: String) extends QuestionAnswer[Human, Option[Int]] {
  override val question = s"How many days older is $humanName1 than $humanName2?"

  // TODO If human not found we could return an error message instead
  override def answer(data: Seq[Human]): Option[Int] = {
    val maybeHuman1 = data.find(_.fullName.startsWith(humanName1))
    val maybeHuman2 = data.find(_.fullName.startsWith(humanName2))

    for {
      human1 <- maybeHuman1
      human2 <- maybeHuman2

    } yield getDaysBetweenDates(human1.dateOfBirth, human2.dateOfBirth)

  }

  // TODO Do it in a better way
  private def getDaysBetweenDates(date1: Date, date2: Date): Int = {
    val millisDiff = date2.getTime - date1.getTime
    Math.round(millisDiff/(1000*60*60*24))
  }
}
