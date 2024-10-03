package model.units.Characters

import model.items.Item
import model.items.Weapons.Weapon
import model.units.Units

trait Character extends Units {
  
  def setWeapon(weapon: Option[Weapon]): Unit

  def setItemInventory(itemList: List[Item]): Unit 

  def getWeapon: Option[Weapon] 

  def getItemInventory: List[Item] 

  def calculateActionBarMax: Double 
  
}
