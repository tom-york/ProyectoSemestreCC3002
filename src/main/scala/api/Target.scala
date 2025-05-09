package api

import model.units.Units
import model.units.characters.{Character, MagicCharacter}

trait Target extends GameObject {
  def beAttacked(attackDmg: Int): Unit
  def moveUnit(unit: Units): Unit
  def characterConsume(character: Character): Unit
  def magicCharacterConsume(magicCharacter: MagicCharacter): Unit
  def equipWeapon(character: Character): Unit
  def healCharacter(magicCharacter: MagicCharacter): Unit
  def purifyEnemy(magicCharacter: MagicCharacter): Unit
  def useMeteorite(magicCharacter: MagicCharacter): Unit
  def useThunder(magicCharacter: MagicCharacter): Unit
}
