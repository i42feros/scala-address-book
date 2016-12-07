package utils

import java.time.LocalDate

import scala.math.Ordering

object DateImplicits {
  trait DateOrdering extends Ordering[LocalDate] {
    def compare(x: LocalDate, y: LocalDate) = x.compareTo(y)
  }

  implicit object LocalDate extends DateOrdering
}
