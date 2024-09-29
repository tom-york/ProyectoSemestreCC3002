package model.items.Potions

import model.items.Potion
import util.Json.{*, given}

class ManaPotion(name: String) extends Potion(name) {

  override def id: String = "ManaPotion"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
