package api

trait Target extends GameObject {
  def beAttacked(attackDmg: Int): Unit
}
