package model.items.Potions.MagicPotions

import model.items.Potions.AbstractPotion
import util.Json.{*, given}

class ManaPotion(name: String) extends AbstractPotion(name) {

  override def id: String = "ManaPotion"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
