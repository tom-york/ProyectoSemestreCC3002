package model.items.weapons.normal

import model.items.weapons.AbstractWeapon
import model.units.characters.Character

class Sword(name: String = "Sword", attackPoints: Int = 69, weight: Int = 69) extends AbstractWeapon(name, attackPoints, weight) {

  override def equipWeapon(character: Character): Unit = {
    character.equipSword(this)
  }
}
