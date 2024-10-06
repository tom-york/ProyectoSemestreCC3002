package model.units.Characters

import model.items.Item
import model.items.Weapons.Weapon
import util.Json.{*, given}

// Abstract class for magic characters, extending AbstractCharacter and adding mana points
abstract class AbstractMagicCharacter(name: String, healthPoints: Int, defensePoints: Int, weight: Int, weaponSlot: Option[Weapon], itemInventory: List[Item], private var manaPoints: Int) extends AbstractCharacter(name, healthPoints, defensePoints, weight, weaponSlot, itemInventory) with MagicCharacter {

  // Setter and getter for the character's mana points
  def setMp(manaP: Int): Unit = {
    manaPoints = manaP
  }

  def getMp: Int = manaPoints

  // Serialize the magic character's attributes to JSON
  override def toJson: JsObj = JsObj(
    "id" -> this.id,
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> getName),
      JsObj("name" -> "hp", "value" -> getHp.toString),
      JsObj("name" -> "dp", "value" -> getDp.toString),
      JsObj("name" -> "mp", "value" -> getMp.toString),
      JsObj("name" -> "weight", "value" -> getWeight.toString),
    ),
    "img" -> "mockImage.gif"
  )
}
