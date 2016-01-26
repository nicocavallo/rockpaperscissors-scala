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
      new GameApp(input).start()
      there was one(input).chooseMode() andThen one(input).wantToContinue()

    }
    "allow to play in Human vs Computer mode" in {
      val input = mock[InputParser]
      input.chooseMode() returns UserVsComputer
      input.chooseName() returns "Nicolas"
      input.chooseMove() returns Rock
      input.wantToContinue() returns Exit
      new GameApp(input).start()
      there was one(input).chooseMode() andThen
        one(input).chooseName() andThen
        one(input).chooseMove() andThen
        one(input).wantToContinue()
    }
    "allow to play two matches in different modes" in {
      val input = mock[InputParser]
      input.chooseMode() returns UserVsComputer thenReturns ComputerVsComputer
      input.chooseName() returns "Nicolas"
      input.chooseMove() returns Rock
      input.wantToContinue() returns Continue thenReturns Exit
      new GameApp(input).start()
      there were two(input).chooseMode()
      there was one(input).chooseName()
      there was one(input).chooseMove()
      there were two(input).wantToContinue()
    }
  }
}
