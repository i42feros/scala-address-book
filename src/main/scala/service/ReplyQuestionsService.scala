package service

import domain.questions.QuestionAnswer
import utils.FileParser


abstract class ReplyQuestionsService[T](fileParser: FileParser[T])(filePath: String) {
  val data: Seq[T] = fileParser.parseFile(filePath)
  val questions: Seq[_ <: QuestionAnswer[T,_ <: Any]]

  def printQuestionsFromData: Unit = {
    questions.foreach { question =>
      println(s"- ${question.question}")
      println(s"  ${question.answerToString(data)}")
    }
  }
}
