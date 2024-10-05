package model.units.Characters

import model.items.Item
import model.items.Weapons.Weapon
import model.units.AbstractUnit
import util.Json.{*, given}

abstract class AbstractCharacter(name: String, healthPoints: Int, defensePoints: Int, weight: Int, private var weaponSlot: Option[Weapon], private var itemInventory: List[Item]) extends AbstractUnit(name, healthPoints, defensePoints, weight) with Character {
  
  def setWeapon(weapon: Option[Weapon]): Unit = {
    weaponSlot = weapon
  }

  def setItemInventory(itemList: List[Item]): Unit = {
    itemInventory = itemList
  }
  
  def getWeapon: Option[Weapon] = weaponSlot
  
  def getItemInventory: List[Item] = itemInventory

  def calculateActionBarMax: Double = {
    if (weaponSlot.isDefined) {
      weight + 0.5 * weaponSlot.get.getWeight
    } 
    else weight
  }
  
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
