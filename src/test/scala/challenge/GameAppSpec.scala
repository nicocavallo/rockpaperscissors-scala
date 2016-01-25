package challenge

import java.io.ByteArrayOutputStream

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import challenge.Move.Rock

class GameAppSpec extends Specification with Mockito {

  "GameApp" should {
    "allow to play in Computer vs Computer mode" in {
      val input = mock[InputParser]
      input.chooseMode() returns ComputerVsComputer
      input.wantToContinue() returns Exit
      val out = new ByteArrayOutputStream()
      Console.withOut(out) {
        new GameApp(input).start()
      }
      out.toString must endWith("Thank you for playing\n")
    }
    "allow to play in Human vs Computer mode" in {
      val input = mock[InputParser]
      input.chooseMode() returns UserVsComputer
      input.chooseName() returns "Nicolas"
      input.chooseMove() returns Rock
      input.wantToContinue() returns Exit
      val out = new ByteArrayOutputStream()
      Console.withOut(out) {
        new GameApp(input).start()
      }
      out.toString must endWith("Thank you for playing\n")
    }
    "allow to play two matches in different modes" in {
      val input = mock[InputParser]
      input.chooseMode() returns UserVsComputer
      input.chooseName() returns "Nicolas"
      input.chooseMove() returns Rock
      input.wantToContinue() returns Continue
      input.chooseMode() returns ComputerVsComputer
      input.wantToContinue() returns Exit
      val out = new ByteArrayOutputStream()
      Console.withOut(out) {
        new GameApp(input).start()
      }
      out.toString must endWith("Thank you for playing\n")
    }
  }
}
