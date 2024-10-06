package model.items.Weapons

import model.units.Characters.Character

// Abstract class for magic weapons, extending AbstractWeapon and adding magic attack points
abstract class AbstractMagicWeapon(name: String, attackPoints: Int, weight: Int, owner: Character, private var magicAttackPoints: Int) extends AbstractWeapon(name, attackPoints, weight, owner) with MagicWeapon {

  // Setter and getter for the magic attack points
  def setMagicAttackPoints(newMAp: Int): Unit = {
    magicAttackPoints = newMAp
  }

  def getMagicAttackPoints: Int = magicAttackPoints
}
