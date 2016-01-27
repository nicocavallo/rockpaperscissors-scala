package challenge

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class GameAppSpec extends Specification with Mockito {

  "GameApp" should {
    "allow to play in Computer vs Computer mode" in {
      val input = mock[InputParser]
      val game = new GameApp(input) with RockPaperScissors
      input.chooseMode() returns ComputerVsComputer
      input.wantToContinue() returns Exit
      game.start()
      there was one(input).chooseMode() andThen one(input).wantToContinue()

    }
    "allow to play in Human vs Computer mode" in {
      val input = mock[InputParser]
      val game = new GameApp(input) with RockPaperScissors
      input.chooseMode() returns UserVsComputer
      input.chooseName() returns "Nicolas"
      input.chooseMove(any[List[Move]]) returns Rock
      input.wantToContinue() returns Exit
      game.start()
      there was one(input).chooseMode() andThen
        one(input).chooseName() andThen
        one(input).chooseMove(any[List[Move]]) andThen
        one(input).wantToContinue()
    }
    "allow to play two matches in different modes" in {
      val input = mock[InputParser]
      val game = new GameApp(input) with RockPaperScissors
      input.chooseMode() returns UserVsComputer thenReturns ComputerVsComputer
      input.chooseName() returns "Nicolas"
      input.chooseMove(any[List[Move]]) returns Rock
      input.wantToContinue() returns Continue thenReturns Exit
      game.start()
      there were two(input).chooseMode()
      there was one(input).chooseName()
      there was one(input).chooseMove(any[List[Move]])
      there were two(input).wantToContinue()
    }
  }

  "GameApp extended" should {
    "allow to play in Computer vs Computer mode" in {
      val input = mock[InputParser]
      val game = new GameApp(input) with RockPaperScissorsSpockLizard
      input.chooseMode() returns ComputerVsComputer
      input.wantToContinue() returns Exit
      game.start()
      there was one(input).chooseMode() andThen one(input).wantToContinue()

    }
    "allow to play in Human vs Computer mode" in {
      val input = mock[InputParser]
      val game = new GameApp(input) with RockPaperScissorsSpockLizard
      input.chooseMode() returns UserVsComputer
      input.chooseName() returns "Nicolas"
      input.chooseMove(any[List[Move]]) returns Rock
      input.wantToContinue() returns Exit
      game.start()
      there was one(input).chooseMode() andThen
        one(input).chooseName() andThen
        one(input).chooseMove(any[List[Move]]) andThen
        one(input).wantToContinue()
    }
    "allow to play two matches in different modes" in {
      val input = mock[InputParser]
      val game = new GameApp(input) with RockPaperScissorsSpockLizard
      input.chooseMode() returns UserVsComputer thenReturns ComputerVsComputer
      input.chooseName() returns "Nicolas"
      input.chooseMove(any[List[Move]]) returns Rock
      input.wantToContinue() returns Continue thenReturns Exit
      game.start()
      there were two(input).chooseMode()
      there was one(input).chooseName()
      there was one(input).chooseMove(any[List[Move]])
      there were two(input).wantToContinue()
    }
  }
}