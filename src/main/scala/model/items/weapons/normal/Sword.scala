package model.items.weapons.normal

import model.items.weapons.AbstractWeapon
import model.units.characters.Character

class Sword(name: String, attackPoints: Int, weight: Int, owner: Character) extends AbstractWeapon(name, attackPoints, weight, owner) {
  def this(owner: Character) = {
    this("Sword", 69, 69, owner)
  }

  override def equipWeapon(character: Character): Unit = {
    character.equipSword(this)
  }
}
