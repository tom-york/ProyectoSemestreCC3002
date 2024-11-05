package model.actions.spells.white

import api.Target
import model.actions.spells.Spell
import model.exceptions.InsufficientManaPoints
import model.units.characters.MagicCharacter
import util.Json.{*, given}

class Purify(name: String = "Purify") extends Spell(name) {

  override def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit = {
    val currentManaPoints = magicCharacter.getMp
    if (currentManaPoints >= 25) {
      tgt.purifyEnemy(magicCharacter)
    }
    else throw new InsufficientManaPoints(magicCharacter, "Purify")
  }

  
  override def id: String = "6" // Identifier for this action

  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "spell→white→purify"
  )
}
