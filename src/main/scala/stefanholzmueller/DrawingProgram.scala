package stefanholzmueller


@main def drawing() =
  val console = RealConsole("enter command: ")
  val loop = CommandLoop(console)
  loop.run(None)