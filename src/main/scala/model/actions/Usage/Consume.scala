package model.actions.Usage

import model.items.Potions.Potion
import util.Json.{*, given}

// Concrete class for consuming potions, extending UsageAction
class Consume(name: String, usableItems: List[Potion]) extends UsageAction(name, usableItems) {

  override def id: String = "Consume" // Identifier for this action
 
  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "usage→consume",
    "targets" -> JsArr(usableItems.map(_.toJson))
  )
}
