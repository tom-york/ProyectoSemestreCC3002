package model.actions.usage

import api.Target
import model.exceptions.{InvalidSourceAction, InvalidSourceTarget}
import model.items.potions.Potion
import model.units.Enemy
import model.units.characters.{Character, MagicCharacter}
import util.Json.{*, given}

// Concrete class for consuming potions, extending UsageAction
class Consume(name: String = "Consume", usableItems: List[Potion]) extends UsageAction(name, usableItems) {
  override def normalCharacterExecute(character: Character, tgt: Target): Unit = {
    tgt.characterConsume(character)
  }

  override def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit = {
    tgt.magicCharacterConsume(magicCharacter)
  }

  override def enemyExecute(enemy: Enemy, tgt: Target): Unit = {
    throw new InvalidSourceAction(enemy.getName, this.getName)
  }
  
  override def id: String = "7" // Identifier for this action
 
  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "usage→consume",
    "targets" -> JsArr(usableItems.map(_.toJson))
  )
}
