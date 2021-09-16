package stefanholzmueller

import scala.annotation.tailrec


class CommandLoop(console: Console) {
  @tailrec
  final def run(canvas: Option[Canvas]): Unit =
    val input: Option[String] = Option(console.readFromPrompt())
    val commandOrError: Either[String, Command] = input.fold(Right(Command.Quit))(Command.parse)
    commandOrError match
      case Right(Command.Quit) =>
        ()
      case Right(command) =>
        console.printLine("TODO: " + command)
        run(None)
      case Left(error) =>
        console.printLine(error)
        run(None)
}
