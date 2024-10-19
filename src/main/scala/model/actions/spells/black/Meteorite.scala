package model.actions.spells.black

import model.actions.spells.Spell
import util.Json.{*, given}

class Meteorite(name: String) extends Spell(name) {
  
  override def id: String = "Meteorite" // Identifier for this action

  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "spell→black→meteorite"
  )
}
