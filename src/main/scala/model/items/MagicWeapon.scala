package model.items

trait MagicWeapon extends Item {

  def setMagicAttackPoints(newMAp: Int): Unit

  def getMagicAttackPoints: Int

}
