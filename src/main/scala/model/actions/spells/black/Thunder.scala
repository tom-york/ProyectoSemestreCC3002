package model.actions.spells.black

import model.actions.spells.Spell
import util.Json.{*, given}

class Thunder(name: String = "Thunder") extends Spell(name) {
  
  override def id: String = "4" // Identifier for this action

  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "spell→black→thunder"
  )
}
