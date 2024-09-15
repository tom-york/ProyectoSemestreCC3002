package model.items.Potions

import model.items.Potion
import util.Json.{*, given}

class HealingPotion extends Potion {

  override def id: String = "HealingPotion"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
