package model.items.weapons.normal

import model.items.weapons.AbstractWeapon
import model.units.characters.Character

class Dagger(name: String, attackPoints: Int, weight: Int, owner: Character) extends AbstractWeapon(name, attackPoints, weight, owner) {
  def this(owner: Character) = {
    this("Dagger", 69, 69, owner)
  }
}
