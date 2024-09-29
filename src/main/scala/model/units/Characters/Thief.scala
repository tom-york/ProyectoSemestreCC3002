package model.units.Characters

import model.items.{Item, Weapon}
import model.units.AbstractCharacter
import util.Json.{*, given}

class Thief(name: String, healthPoints: Int, defensePoints: Int, weight: Int, weaponSlot: Option[Weapon], itemInventory: List[Item]) extends AbstractCharacter(name, healthPoints, defensePoints, weight, weaponSlot, itemInventory) {

  override def id: String = "Thief"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> getName),
      JsObj("name" -> "hp", "value" -> getHp),
      JsObj("name" -> "dp", "value" -> getDp),
      JsObj("name" -> "weight", "value" -> getWeight),
    )
  )
}
