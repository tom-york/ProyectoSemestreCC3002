package model.items.Weapons

import model.items.Item

trait MagicWeapon extends Item {

  def setMagicAttackPoints(newMAp: Int): Unit

  def getMagicAttackPoints: Int

}
