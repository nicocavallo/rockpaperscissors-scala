package challenge

case class Game(p1: Player, p2:Player) {

  def play():GameResult = Move.compare(p1.move,p2.move) match {
    case 0 => Tie
    case -1 => Win(p1)
    case 1 => Win(p2)
  }

}
sealed trait GameResult
case object Tie extends GameResult
case class Win(player:Player) extends GameResult
