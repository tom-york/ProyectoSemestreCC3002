package model.actions.spells.white

import api.Target
import model.actions.spells.Spell
import model.exceptions.{InsufficientManaPoints, InvalidSourceAction}
import model.units.Enemy
import model.units.characters.{Character, MagicCharacter}
import util.Json.{*, given}

class Heal(name: String = "Heal") extends Spell(name) {

  override def normalCharacterExecute(character: Character, tgt: Target): Unit = {
    throw new InvalidSourceAction(character.getName, this.getName)
  }

  override def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit = {
    val currentManaPoints = magicCharacter.getMp
    if (currentManaPoints >= 20) {
      tgt.healUnit(magicCharacter)
    }
    else throw new InsufficientManaPoints(magicCharacter, "Heal")
  }

  override def enemyExecute(enemy: Enemy, tgt: Target): Unit = {
    throw new InvalidSourceAction(enemy.getName, this.getName)
  }

  override def id: String = "5" // Identifier for this action
  
  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "spell→white→heal"
  )
}
