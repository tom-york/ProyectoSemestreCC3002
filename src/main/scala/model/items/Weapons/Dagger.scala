package model.items.Weapons

import model.items.Weapon
import util.Json.{*, given}

class Dagger extends Weapon {

  override def id: String = "Dagger"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
