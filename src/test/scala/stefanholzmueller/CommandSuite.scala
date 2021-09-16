package stefanholzmueller


class CommandSuite extends munit.FunSuite {

  test("parse quit command") {
    assertEquals(Command.parse("Q"), Right(Command.Quit))
    assertEquals(Command.parse("   Q\t"), Right(Command.Quit))
  }

  test("parse canvas command") {
    assertEquals(Command.parse("C 1 2"), Right(Command.Canvas(1, 2)))
    assertEquals(Command.parse(" C  3 5 "), Right(Command.Canvas(3, 5)))
  }

  test("parse line command") {
    assertEquals(Command.parse("L 1 2 3 4"), Right(Command.Line(1, 2, 3, 4)))
  }

  test("parse rect command") {
    assertEquals(Command.parse("R 1 2 3 4"), Right(Command.Rectangle(1, 2, 3, 4)))
  }

}
