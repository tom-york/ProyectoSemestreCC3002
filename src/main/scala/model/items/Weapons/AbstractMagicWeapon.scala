package model.items.Weapons

import model.units.Characters.Character

abstract class AbstractMagicWeapon(name: String, attackPoints: Int, weight: Int, owner: Character, private var magicAttackPoints: Int) extends AbstractWeapon(name, attackPoints, weight, owner) with MagicWeapon {

  def setMagicAttackPoints(newMAp: Int): Unit = {
    
    magicAttackPoints = newMAp
    
  }

  def getMagicAttackPoints: Int = magicAttackPoints
  
}
