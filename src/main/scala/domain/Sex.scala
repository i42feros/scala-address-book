package domain


sealed abstract class Sex(value: String)

object Sex {

  case object Male extends Sex("male")

  case object Female extends Sex("female")

  val values = Seq(Male, Female)

  def valueOf(value: String): Option[Sex] = value.toLowerCase match {
    case "male" => Some(Male)
    case "female" => Some(Female)
    case _ => None
  }

}
