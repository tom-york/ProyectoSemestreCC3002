package model.items.weapons.magic

import model.items.weapons.AbstractMagicWeapon
import model.units.characters.Character

class Wand(name: String = "Wand", attackPoints: Int = 69, weight: Int = 69, magicAttackPoints: Int = 69) extends AbstractMagicWeapon(name, attackPoints, weight, magicAttackPoints) {

  override def equipWeapon(character: Character): Unit = {
    character.equipWand(this)
  }
}
