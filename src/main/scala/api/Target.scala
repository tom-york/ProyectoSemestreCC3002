package api

import model.units.Units
import model.units.characters.MagicCharacter

trait Target extends GameObject {
  def beAttacked(attackDmg: Int): Unit
  def moveUnit(unit: Units): Unit
  def unitConsume(unit: Units): Unit
  def unitMagicConsume(character: MagicCharacter): Unit
}
