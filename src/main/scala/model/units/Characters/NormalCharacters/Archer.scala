package model.units.Characters.NormalCharacters

import model.items.Item
import model.items.Weapons.Weapon
import model.units.Characters.AbstractCharacter
import util.Json.{*, given}

class Archer(name: String, healthPoints: Int, defensePoints: Int, weight: Int, weaponSlot: Option[Weapon], itemInventory: List[Item]) extends AbstractCharacter(name, healthPoints, defensePoints, weight, weaponSlot, itemInventory) {
  
  override def id: String = "Archer"

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
