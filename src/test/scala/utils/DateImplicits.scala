package utils

import java.util.Date

object DateImplicits {
  implicit def getDateIgnoringErrors(value: Either[String, Date]): Date =
    value.fold(_ => None, date => Some(date)).get
}
