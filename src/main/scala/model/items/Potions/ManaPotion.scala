package model.items.Potions

import model.items.Potion
import util.Json.{*, given}

class ManaPotion extends Potion {

  override def id: String = "ManaPotion"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
