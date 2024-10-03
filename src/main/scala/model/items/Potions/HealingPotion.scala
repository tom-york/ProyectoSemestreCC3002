package model.items.Potions

import model.items.AbstractPotion
import util.Json.{*, given}

class HealingPotion(name: String) extends AbstractPotion(name) {

  override def id: String = "HealingPotion"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
