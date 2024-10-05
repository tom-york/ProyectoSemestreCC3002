package model.actions.Usage

import model.items.Potions.Potion
import util.Json.{*, given}

class Consume(name: String, usableItems: List[Potion]) extends UsageAction(name, usableItems) {
  val id: String = "Consume"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "usage→consume",
    "targets" -> JsArr(usableItems.map(_.toJson))
  )
}
