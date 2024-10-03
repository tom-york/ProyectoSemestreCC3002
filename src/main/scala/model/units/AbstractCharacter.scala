package model.units

import model.items.{Item, AbstractWeapon}


abstract class AbstractCharacter(name: String, healthPoints: Int, defensePoints: Int, weight: Int, private var weaponSlot: Option[AbstractWeapon], private var itemInventory: List[Item]) extends AbstractUnit(name, healthPoints, defensePoints, weight) with Character {
  
  def setWeapon(weapon: Option[AbstractWeapon]): Unit = {
    weaponSlot = weapon
  }

  def setItemInventory(itemList: List[Item]): Unit = {
    itemInventory = itemList
  }
  
  def getWeapon: Option[AbstractWeapon] = weaponSlot
  
  def getItemInventory: List[Item] = itemInventory

  def calculateActionBarMax: Double = {
    if (weaponSlot.isDefined) {
      weight + 0.5 * weaponSlot.get.getWeight
    } 
    else weight
  }
}
