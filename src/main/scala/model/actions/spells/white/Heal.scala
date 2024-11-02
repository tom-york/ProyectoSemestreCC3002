package model.actions.spells.white

import model.actions.spells.Spell
import util.Json.{*, given}

class Heal(name: String = "Heal") extends Spell(name) {

  override def id: String = "5" // Identifier for this action
  
  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "spell→white→heal"
  )
}
