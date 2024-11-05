package model.units.characters

import model.items.Item
import model.items.weapons.Weapon
import model.units.Units

// Trait defining additional behavior for character units, including weapons and items
trait Character extends Units {

  def setWeapon(weapon: Option[Weapon]): Unit  // Set the character's weapon
  
  def setItemInventory(itemList: List[Item]): Unit  // Set the character's inventory of items

  def getWeapon: Option[Weapon]  // Get the character's weapon
  
  def getItemInventory: List[Item]  // Get the character's inventory of items

  def calculateActionBarMax: Double  // Calculate the action bar max based on the character's weight and weapon
  
  def equipStaff(weapon: Weapon): Unit

  def equipWand(weapon: Weapon): Unit

  def equipBow(weapon: Weapon): Unit

  def equipDagger(weapon: Weapon): Unit

  def equipSword(weapon: Weapon): Unit

}
