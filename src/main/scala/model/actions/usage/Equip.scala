package model.actions.usage

import model.items.weapons.Weapon
import util.Json.{*, given}

class Equip(name: String, usableItems: List[Weapon]) extends UsageAction(name, usableItems){

  override def id: String = "8" // Identifier for this action

  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "usage→equip",
    "targets" -> JsArr(usableItems.map(_.toJson))
  )
}
