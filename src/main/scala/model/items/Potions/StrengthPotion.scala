package model.items.Potions

import model.items.Potion
import util.Json.{*, given}

class StrengthPotion extends Potion {

  override def id: String = "StrengthPotion"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
