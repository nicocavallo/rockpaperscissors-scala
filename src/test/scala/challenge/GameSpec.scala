package challenge

import org.specs2.mutable.Specification
import GameSpec._
import Move._

class GameSpec extends Specification {

  "A Game" should {
    "end up in a Tie if both player make the same move" in {
      playGame(withPlayer = buildRockPlayer("player1"), andPlayer = buildRockPlayer("player2")) === Tie
      playGame(withPlayer = buildPaperPlayer("player1"), andPlayer = buildPaperPlayer("player2")) === Tie
      playGame(withPlayer = buildScissorsPlayer("player1"), andPlayer = buildScissorsPlayer("player2")) === Tie
    }
    "end up with paper beating rock" in {
      val player1 = buildPaperPlayer("Player1")
      val player2 = buildRockPlayer("Player1")
      playGame(player1,player2) === playGame(player2,player1)
    }
    "end up with rock beating scissors" in {
      val player1 = buildRockPlayer("Player1")
      val player2 = buildScissorsPlayer("Player1")
      playGame(player1,player2) === playGame(player2,player1)
    }
    "end up with scissors beating paper" in {
      val player1 = buildScissorsPlayer("Player1")
      val player2 = buildPaperPlayer("Player1")
      playGame(player1,player2) === playGame(player2,player1)
    }

  }

}

object GameSpec {

  def playGame(withPlayer:Player, andPlayer: Player) =
    new Game(withPlayer,andPlayer).play()

  def buildRockPlayer(name:String) = Player(name, Rock)
  def buildPaperPlayer(name:String) = Player(name, Paper)
  def buildScissorsPlayer(name:String) = Player(name, Scissors)

}