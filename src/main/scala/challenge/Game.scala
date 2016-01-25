package challenge

case class Game(p1: Player, p2:Player) {

  def play():GameResult = Tie

}
sealed trait GameResult
case object Tie extends GameResult
