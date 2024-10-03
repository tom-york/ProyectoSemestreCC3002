package model.units.Characters

import model.items.Item
import model.items.Weapons.Weapon

abstract class AbstractMagicCharacter(name: String, healthPoints: Int, defensePoints: Int, weight: Int, weaponSlot: Option[Weapon], itemInventory: List[Item], private var manaPoints: Int) extends AbstractCharacter(name, healthPoints, defensePoints, weight, weaponSlot, itemInventory) with MagicCharacter {

  def setMp(manaP: Int): Unit = {
    manaPoints = manaP
  }

  def getMp: Int = manaPoints

}
