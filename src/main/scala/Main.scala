import service.HumanQuestionsService

object Main extends App {
  println("Address book app running!")
  println("* * Questions * *")

  val filePath = getClass.getResource("/AddressBook").getPath
  val humanService = new HumanQuestionsService(filePath)

  humanService.printQuestionsFromData
}
