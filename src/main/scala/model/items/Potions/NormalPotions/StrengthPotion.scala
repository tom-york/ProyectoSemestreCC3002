package model.items.Potions.NormalPotions

import model.items.Potions.AbstractPotion
import util.Json.{*, given}

class StrengthPotion(name: String) extends AbstractPotion(name) {

  override def id: String = "StrengthPotion"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
