package model.items.Weapons

import model.items.MagicWeapon
import util.Json.{*, given}

class Wand extends MagicWeapon {

  override def id: String = "Wand"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
