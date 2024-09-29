package model.units.Characters

import model.items.{Item, Weapon}
import model.units.AbstractMagicCharacter
import util.Json.{*, given}

class BlackWizard(name: String, healthPoints: Int, defensePoints: Int, weight: Int, weaponSlot: Option[Weapon], itemInventory: List[Item], manaPoints: Int) extends AbstractMagicCharacter(name, healthPoints, defensePoints, weight, weaponSlot, itemInventory, manaPoints) {
  
  override def id: String = "BlackWizard"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> getName),
      JsObj("name" -> "hp", "value" -> getHp),
      JsObj("name" -> "dp", "value" -> getDp),
      JsObj("name" -> "dp", "value" -> getMp),
      JsObj("name" -> "weight", "value" -> getWeight),
    )
  )
}
