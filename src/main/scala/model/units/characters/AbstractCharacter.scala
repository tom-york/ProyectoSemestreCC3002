package model.units.characters

import model.exceptions.WeaponNotPresent
import model.items.Item
import model.items.weapons.Weapon
import model.panels.IPanel
import model.units.AbstractUnit
import util.Json.{*, given}

// Abstract class for characters, implementing the Character trait and adding weapon and item inventory
abstract class AbstractCharacter(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, private var weaponSlot: Option[Weapon], private var itemInventory: List[Item]) extends AbstractUnit(name, healthPoints, defensePoints, weight, panel) with Character {

  // Setter and getter for the weapon slot
  def setWeapon(weapon: Option[Weapon]): Unit = {
    weaponSlot = weapon
  }

  def getWeapon: Option[Weapon] = weaponSlot

  // Setter and getter for the item inventory
  def setItemInventory(itemList: List[Item]): Unit = {
    itemInventory = itemList
  }

  def getItemInventory: List[Item] = itemInventory
  
  override def getTotalDamage: Int = weaponSlot.getOrElse(throw new WeaponNotPresent(this)).getAttackPoints

  // Calculates the action bar max, adding half the weapon weight if a weapon is equipped
  def calculateActionBarMax: Double = {
    if (weaponSlot.isDefined) {
      weight + 0.5 * weaponSlot.get.getWeight
    } else weight
  }
  
  // Serialize the character's attributes and inventory to JSON
  override def toJson: JsObj = JsObj(
    "id" -> this.id,
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> getName),
      JsObj("name" -> "hp", "value" -> getHp.toString),
      JsObj("name" -> "dp", "value" -> getDp.toString),
      JsObj("name" -> "weight", "value" -> getWeight.toString),
    ),
    "img" -> "mockImage.gif"
  )
}
