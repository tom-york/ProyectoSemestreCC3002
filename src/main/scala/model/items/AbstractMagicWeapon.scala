package model.items

import model.units.AbstractCharacter

abstract class AbstractMagicWeapon(name: String, attackPoints: Int, weight: Int, owner: AbstractCharacter, private var magicAttackPoints: Int) extends AbstractWeapon(name, attackPoints, weight, owner) with MagicWeapon {

  def setMagicAttackPoints(newMAp: Int): Unit = {
    
    magicAttackPoints = newMAp
    
  }

  def getMagicAttackPoints: Int = magicAttackPoints
  
}
