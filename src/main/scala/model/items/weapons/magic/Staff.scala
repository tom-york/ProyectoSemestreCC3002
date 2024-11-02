package model.items.weapons.magic

import model.items.weapons.AbstractMagicWeapon
import model.units.characters.Character

class Staff(name: String, attackPoints: Int, weight: Int, owner: Character, magicAttackPoints: Int) extends AbstractMagicWeapon(name, attackPoints, weight, owner, magicAttackPoints) {
  def this(owner: Character) = {
    this("Staff", 69, 69, owner, 69)
  }
}
