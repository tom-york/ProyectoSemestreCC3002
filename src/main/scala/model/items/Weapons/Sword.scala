package model.items.Weapons

import model.items.Weapon
import util.Json.{*, given}

class Sword extends Weapon {

  override def id: String = "Sword"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
