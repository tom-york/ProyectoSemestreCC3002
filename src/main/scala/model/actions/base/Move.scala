package model.actions.base

import api.Target
import model.actions.AbstractAction
import model.units.Enemy
import model.units.characters.{Character, MagicCharacter}
import util.Json.{*, given}

class Move(name: String = "Move") extends AbstractAction(name) {
  override def normalCharacterExecute(character: Character, tgt: Target): Unit = {
    tgt.moveUnit(character)
  }

  override def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit = {
    tgt.moveUnit(magicCharacter)
  }

  override def enemyExecute(enemy: Enemy, tgt: Target): Unit = {
    tgt.moveUnit(enemy)
  }
  
  override def id: String = "2" // Identifier for this action

  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "base→move"
  )
}
