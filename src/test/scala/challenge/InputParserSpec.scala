package challenge

import java.io.StringReader
import challenge.Move.{Rock, Paper,Scissors}

import org.specs2.mutable.Specification

/**
 * Created by Nicolas on 25/01/2016.
 */
class InputParserSpec extends Specification{

  import InputParserSpec._

  "An InputParser" should {
    "parse a move" in {
      createParser("R\n").chooseMove() === Rock
      createParser("P\n").chooseMove() === Paper
      createParser("S\n").chooseMove() === Scissors
    }
    "parse a move after some failed attempts" in {
      createParser("T\nR\n").chooseMove() === Rock
      createParser("T\nA\nR\n").chooseMove() === Rock
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