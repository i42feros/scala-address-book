package domain.questions

trait QuestionAnswer[T, V] {
  val question: String
  def answer(data: Seq[T]): V
}
