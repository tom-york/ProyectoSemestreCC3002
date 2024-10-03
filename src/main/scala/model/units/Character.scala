package model.units

import model.items.{Weapon, Item}

trait Character extends Units {
  
  def setWeapon(weapon: Option[Weapon]): Unit

  def setItemInventory(itemList: List[Item]): Unit 

  def getWeapon: Option[Weapon] 

  def getItemInventory: List[Item] 

  def calculateActionBarMax: Double 
  
}
