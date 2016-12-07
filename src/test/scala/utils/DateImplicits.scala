package utils

import java.time.LocalDate

object DateImplicits {
  implicit def getDateIgnoringErrors(value: Either[String, LocalDate]): LocalDate =
    value.fold(_ => None, date => Some(date)).get
}
