package model.actions.usage

import api.Target
import model.items.potions.Potion
import model.units.Enemy
import model.units.characters.{Character, MagicCharacter}
import util.Json.{*, given}

// Concrete class for consuming potions, extending UsageAction
class Consume(name: String = "Consume", usableItems: List[Potion]) extends UsageAction(name, usableItems) {
  override def normalCharacterExecute(character: Character, tgt: Target): Unit = {
    tgt.unitConsume(character)
  }

  override def magicCharacterExecute(character: MagicCharacter, tgt: Target): Unit = {
    tgt.unitMagicConsume(character)
  }

  override def enemyExecute(enemy: Enemy, tgt: Target): Unit = {
    tgt.unitConsume(enemy)
  }
  
  override def id: String = "7" // Identifier for this action
 
  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "usage→consume",
    "targets" -> JsArr(usableItems.map(_.toJson))
  )
}
