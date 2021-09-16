package stefanholzmueller


class CommandLoopSuite extends munit.FunSuite {

  private def assertOutput(inputs: List[String], expectedOutputs: List[String]) =
    val testConsole = TestConsole(inputs)
    val commandLoop = CommandLoop(testConsole)
    commandLoop.run(None)
    assertEquals(testConsole.getOutput, expectedOutputs.map(_ + System.lineSeparator).mkString)

  test("immediately quit") {
    assertOutput(List("Q"), List())
  }

  test("type nonsense") {
    assertOutput(List("asdf"), List(Command.errorInvalidCommand))
  }

  test("create canvas, then quit".ignore) {
    assertOutput(List("C 1 1", "Q"), List(
      """---
        || |
        |---
        |""".stripMargin))
  }

}
