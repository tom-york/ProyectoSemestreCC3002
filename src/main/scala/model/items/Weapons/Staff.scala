package model.items.Weapons

import model.items.MagicWeapon
import util.Json.{*, given}

class Staff extends MagicWeapon {

  override def id: String = "Staff"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
