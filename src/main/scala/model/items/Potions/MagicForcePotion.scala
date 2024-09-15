package model.items.Potions

import model.items.Potion
import util.Json.{*, given}

class MagicForcePotion extends Potion {

  override def id: String = "MagicForcePotion"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
