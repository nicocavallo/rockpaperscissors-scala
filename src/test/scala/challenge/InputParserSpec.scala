package challenge

import java.io.StringReader

import org.specs2.mutable.Specification
import InputParserSpec._
/**
 * Created by Nicolas on 25/01/2016.
 */
class InputParserSpec extends Specification{

  val moves = List(Rock,Paper, Scissors)

  "An InputParser" should {
    "parse a move" in {
      createParser("1\n").chooseMove(moves) === Rock
      createParser("2\n").chooseMove(moves) === Paper
      createParser("3\n").chooseMove(moves) === Scissors
    }
    "parse a move after some failed attempts" in {
      createParser("T\n1\n").chooseMove(moves) === Rock
      createParser("T\nA\n1\n").chooseMove(moves) === Rock
    }
    "parse a move after entering 0 (should be >0)" in {
      createParser("0\n1\n").chooseMove(moves) === Rock
    }
    "parse a move after entering 5 (should be <= moves.size)" in {
      createParser("5\n1\n").chooseMove(moves) === Rock
    }
    "parse a game mode selection" in {
      createParser("1\n").chooseMode() === UserVsComputer
      createParser("2\n").chooseMode() === ComputerVsComputer
    }
    "parse a game mode selection after a failed attempt" in {
      createParser("3\n1\n").chooseMode() === UserVsComputer
      createParser("\n2\n").chooseMode() === ComputerVsComputer
    }
    "parse an action (Quit or Continue)" in {
      createParser("Y\n").wantToContinue() === Continue
      createParser("N\n").wantToContinue() === Exit
    }
    "parse an action (Quit or Continue) after a failed attempt" in {
      createParser("\nN\n").wantToContinue() === Exit
    }
    "read name from input" in {
      createParser("Nico").chooseName() === "Nico"
    }
    "read name from input after trying to insert an empty space" in {
      createParser("\nNico").chooseName() === "Nico"
    }
  }

}

object InputParserSpec {
  def createParser(s: String) = new InputParser(new StringReader(s))
}