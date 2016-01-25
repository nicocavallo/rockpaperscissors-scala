package challenge

case class Player(name: String, move:Move)

sealed trait Move
case object Rock extends Move