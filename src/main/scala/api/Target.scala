package api

import model.units.Units
import model.units.characters.{Character, MagicCharacter}

trait Target extends GameObject {
  def beAttacked(attackDmg: Int): Unit
  def moveUnit(unit: Units): Unit
  def characterConsume(character: Character): Unit
  def magicCharacterConsume(character: MagicCharacter): Unit
}
