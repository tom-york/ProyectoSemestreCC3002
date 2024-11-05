package model.actions.spells.black

import api.Target
import model.actions.spells.Spell
import model.exceptions.InsufficientManaPoints
import model.units.characters.MagicCharacter
import util.Json.{*, given}

class Meteorite(name: String = "Meteorite") extends Spell(name) {
  
  override def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit = {
    val currentManaPoints = magicCharacter.getMp
    if (currentManaPoints >= 50) {
      tgt.useMeteorite(magicCharacter)
    }
    else throw new InsufficientManaPoints(magicCharacter, "Heal")
  }
  
  override def id: String = "3" // Identifier for this action

  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "spell→black→meteorite"
  )
}
