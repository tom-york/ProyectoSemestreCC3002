package model.items.weapons.magic

import model.items.weapons.AbstractMagicWeapon
import model.units.characters.Character

class Wand(name: String, attackPoints: Int, weight: Int, owner: Character, magicAttackPoints: Int) extends AbstractMagicWeapon(name, attackPoints, weight, owner, magicAttackPoints) {
  def this(owner: Character) = {
    this("Wand", 69, 69, owner, 69)
  }
}
