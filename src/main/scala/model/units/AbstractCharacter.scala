package model.units

import model.items.{Item, Weapon}


abstract class AbstractCharacter extends AbstractUnit {
  
  private var weaponSlot: Weapon = _
  
  private var itemInventory: List[Item] = _

  def setWeapon(weapon: Weapon): Unit = {
    weaponSlot = weapon
  }

  def setItemInventory(itemList: List[Item]): Unit = {
    itemInventory = itemList
  }
  
  def getWeapon: Weapon = weaponSlot
  
  def getItemInventory: List[Item] = itemInventory
  
}
