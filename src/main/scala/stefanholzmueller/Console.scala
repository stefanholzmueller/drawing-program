package stefanholzmueller

import scala.io.StdIn


trait Console {
  def printLine(s: String): Unit
  def readFromPrompt(): String|Null
}

class RealConsole(prompt: String) extends Console {
  override def printLine(s: String): Unit =
    println(s)
  override def readFromPrompt(): String|Null =
    StdIn.readLine(prompt)
}

class TestConsole(fakeInput: List[String]) extends Console {
  val sb = new StringBuilder()
  var input = fakeInput

  override def printLine(s: String): Unit =
    sb.append(s).append(System.lineSeparator)

  override def readFromPrompt(): String|Null =
    input match
      case Nil =>
        null
      case head :: tail =>
        input = tail
        head

  def getOutput: String = sb.toString
}