package model.items.Potions

import model.items.Potion
import util.Json.{*, given}

class StrengthPotion(name: String) extends Potion(name) {

  override def id: String = "StrengthPotion"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
