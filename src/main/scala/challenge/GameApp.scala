package challenge

import java.io.{Reader, InputStreamReader, InputStream, OutputStream}

import challenge.Move.{Move, Paper, Rock, Scissors}

import scala.io.StdIn

object GameApp extends App {
  val input = new InputParser(new InputStreamReader(System.in))
  new GameApp(input).start()
}

class GameApp(in: InputParser) {

  def start(): Unit = {
    println("Starting a new Game")
    in.chooseMode() match {
      case ComputerVsComputer =>
        val p1 = Player.random("Computer 1")
        val p2 = Player.random("Computer 2")
        println(s"${p1.name} chose '${p1.move}'")
        println(s"${p2.name} chose '${p2.move}'")
        new Game(p1, p2).play() match {
          case Win(player) => println(s"The winner is '$player'")
          case Tie => println("It was a Tie")
        }
      case UserVsComputer =>
        val name = in.chooseName()
        val move = in.chooseMove()
        val p1 = Player(name, move)
        val p2 = Player.random("Computer")
        println(s"${p1.name} chose '${p1.move}'")
        println(s"${p2.name} chose '${p2.move}'")
        new Game(p1, p2).play()  match {
          case Win(player) => println(s"The winner is '$player'")
          case Tie => println("It was a Tie")
        }
    }
    in.wantToContinue() match {
      case Continue => start()
      case Exit => println("Thank you for playing")
    }
  }

}

class InputParser(in: Reader) {
  val ModeSelectionPrompt =
    """
      |Please choose a mode:
      |1.  Player vs Computer
      |2.  Computer vs Computer
""".stripMargin

  val MoveSelectionPrompt =
    """
      |Please, choose a move:
      |[R]. Rock
      |[P]. Paper
      |[S]. Scissors
""".stripMargin

  def chooseMode(): GameMode = Console.withIn(in) {
    def chooseModeRec(): GameMode = StdIn.readLine(ModeSelectionPrompt) match {
      case "1" => UserVsComputer
      case "2" => ComputerVsComputer
      case _ =>
        println("Error: Please choose 1 or 2")
        chooseModeRec()
    }
    chooseModeRec()
  }

  def wantToContinue(): Action = Console.withIn(in) {
    def wantToContinueRec():Action = StdIn.readLine("Do you want to continue?(Y/N) ").toUpperCase match {
      case "Y" => Continue
      case "N" => Exit
      case _ =>
        println("Error: please type Y or N")
        wantToContinueRec()
    }
    wantToContinueRec()
  }

  def chooseName(): String = Console.withIn(in) {
    def chooseNameRec(): String = StdIn.readLine("Please, choose a name: ") match {
      case "" => chooseNameRec()
      case name => name
    }
    chooseNameRec()
  }

  def chooseMove(): Move = Console.withIn(in) {
    def chooseMoveRec(): Move = StdIn.readLine(MoveSelectionPrompt) match {
      case "R" => Rock
      case "P" => Paper
      case "S" => Scissors
      case _ =>
        println("Error!")
        chooseMoveRec()
    }
    chooseMoveRec()
  }
}

trait GameMode

case object UserVsComputer extends GameMode

case object ComputerVsComputer extends GameMode

trait Action

case object Continue extends Action

case object Exit extends Action