package model.items.Potions

import model.items.Potion
import util.Json.{*, given}

class MagicForcePotion(name: String) extends Potion(name) {

  override def id: String = "MagicForcePotion"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
