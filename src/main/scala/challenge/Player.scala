package challenge

import challenge.Move.Move

case class Player(name: String, move:Move) {
  override def toString = name
}

object Player {
  def random(name: String) = Player(name,Move.random)
}