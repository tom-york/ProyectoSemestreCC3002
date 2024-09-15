package model.items.Weapons

import model.items.Weapon
import util.Json.{*, given}

class Bow extends Weapon {

  override def id: String = "Bow"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
