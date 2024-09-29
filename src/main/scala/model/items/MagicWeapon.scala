package model.items

import model.units.AbstractCharacter

abstract class MagicWeapon(name: String, attackPoints: Int, weight: Int, owner: AbstractCharacter, private var magicAttackPoints: Int) extends Weapon(name, attackPoints, weight, owner) {

  def setMagicAttackPoints(newMAp: Int): Unit = {
    
    magicAttackPoints = newMAp
    
  }

  def getMagicAttackPoints: Int = magicAttackPoints
  
}
