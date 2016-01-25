package challenge

object Moves {

  sealed trait Move
  case object Rock extends Move
  case object Paper extends Move
  case object Scissors extends Move

  def compare(m1: Move, m2: Move): Int = (m1,m2) match {
    case (Rock,Rock) => 0
    case (Rock,Paper) => 1
    case (Rock,Scissors) => -1
    case (Paper,Paper) => 0
    case (Paper,Scissors) => 1
    case (Paper,Rock) => -1
    case (Scissors,Scissors) => 0
    case (Scissors,Rock) => 1
    case (Scissors,Paper) => -1
  }
}
