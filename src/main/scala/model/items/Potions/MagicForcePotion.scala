package model.items.Potions

import model.items.AbstractPotion
import util.Json.{*, given}

class MagicForcePotion(name: String) extends AbstractPotion(name) {

  override def id: String = "MagicForcePotion"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
