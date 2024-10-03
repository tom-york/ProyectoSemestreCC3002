package model.items.Potions

import model.items.AbstractPotion
import util.Json.{*, given}

class ManaPotion(name: String) extends AbstractPotion(name) {

  override def id: String = "ManaPotion"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
