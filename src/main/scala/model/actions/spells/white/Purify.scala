package model.actions.spells.white

import model.actions.spells.Spell
import util.Json.{*, given}

class Purify(name: String) extends Spell(name) {
  
  override def id: String = "Purify" // Identifier for this action

  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "spell→white→purify"
  )
}
