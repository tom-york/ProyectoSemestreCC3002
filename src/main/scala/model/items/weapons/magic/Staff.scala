package model.items.weapons.magic

import model.items.weapons.AbstractMagicWeapon
import model.units.characters.Character

class Staff(name: String = "Staff", attackPoints: Int = 69, weight: Int = 69, magicAttackPoints: Int = 69) extends AbstractMagicWeapon(name, attackPoints, weight, magicAttackPoints) {

  override def equipWeapon(character: Character): Unit = {
    character.equipStaff(this)
  }
  
}
