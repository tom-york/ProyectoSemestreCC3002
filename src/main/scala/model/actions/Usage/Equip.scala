package model.actions.Usage

import model.items.Weapons.Weapon
import util.Json.{*, given}

class Equip(name: String, usableItems: List[Weapon]) extends UsageAction(name, usableItems){
  val id: String = "Equip"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "usage→equip",
    "targets" -> JsArr(usableItems.map(_.toJson))
  )
}
