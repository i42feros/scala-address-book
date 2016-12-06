package domain


sealed abstract class Sex(value: String)

object Sex {

  case object Male extends Sex("male")

  case object Female extends Sex("male")

}