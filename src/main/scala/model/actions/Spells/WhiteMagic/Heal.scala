package model.actions.Spells.WhiteMagic

import model.actions.Spells.Spell
import util.Json.{*, given}

class Heal(name: String) extends Spell(name) {

  override def id: String = "Heal" // Identifier for this action
  
  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "spell→whiteMagic→heal"
  )
}
