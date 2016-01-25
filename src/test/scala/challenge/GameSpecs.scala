package challenge

import org.specs2.mutable.Specification

class GameSpecs extends Specification {

  "A Game" should {
    "end up in a Tie if both player make the same move" in {
      new Game(Player("Player 1", Rock),Player("Player 2", Rock)).play() === Tie
    }
  }

}