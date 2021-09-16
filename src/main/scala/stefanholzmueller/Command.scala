package stefanholzmueller


enum Command:
  case Canvas(w: Int, h: Int)
  case Line(x1: Int, y1: Int, x2: Int, y2: Int)
  case Rectangle(x1: Int, y1: Int, x2: Int, y2: Int)
  // case BucketFill(x: Int, y: Int, c: Char)
  case Quit

object Command:
  private val PatternCanvas = """C (\d+) (\d+)""".r
  private val PatternLine = """L (\d+) (\d+) (\d+) (\d+)""".r
  private val PatternRectangle = """R (\d+) (\d+) (\d+) (\d+)""".r
  private val PatternQuit = "Q".r

  def parse(string: String): Either[String, Command] =
    string.trim.replaceAll("\\s+", " ") match
      case PatternCanvas(w, h) => Right(Command.Canvas(w.toInt, h.toInt))
      case PatternLine(x1, y1, x2, y2) => Right(Command.Line(x1.toInt, y1.toInt, x2.toInt, y2.toInt))
      case PatternRectangle(x1, y1, x2, y2) => Right(Command.Rectangle(x1.toInt, y1.toInt, x2.toInt, y2.toInt))
      case PatternQuit() => Right(Command.Quit)
      case _ => Left(errorInvalidCommand)

  val errorInvalidCommand = "Unrecognized command."