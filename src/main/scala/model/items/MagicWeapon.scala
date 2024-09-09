package model.items

class MagicWeapon extends Weapon {

  private var magicAttackPoints: Int = _

  def setMagicAttackPoints(newMap: Int): Unit = {
    
    magicAttackPoints = newMap
    
  }

  def getMagicAttackPoints: Int = magicAttackPoints
  
}
