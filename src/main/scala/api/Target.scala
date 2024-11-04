package api

import model.units.Units

trait Target extends GameObject {
  def beAttacked(attackDmg: Int): Unit
  def moveUnit(unit: Units): Unit
}
