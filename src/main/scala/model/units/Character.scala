package model.units

import model.items.{AbstractWeapon, Item}

trait Character extends Units {
  
  def setWeapon(weapon: Option[AbstractWeapon]): Unit

  def setItemInventory(itemList: List[Item]): Unit 

  def getWeapon: Option[AbstractWeapon] 

  def getItemInventory: List[Item] 

  def calculateActionBarMax: Double 
  
}
