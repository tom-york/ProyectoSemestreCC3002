package model.actions.usage

import api.Target
import model.exceptions.InvalidSourceAction
import model.items.weapons.Weapon
import model.units.Enemy
import model.units.characters.{Character, MagicCharacter}
import util.Json.{*, given}

class Equip(name: String = "Equip", usableItems: List[Weapon]) extends UsageAction(name, usableItems){
  override def normalCharacterExecute(character: Character, tgt: Target): Unit = {
    tgt.equipWeapon(character)
  }

  override def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit = {
    normalCharacterExecute(magicCharacter, tgt)  
  }
  
  override def id: String = "8" // Identifier for this action

  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "usage→equip",
    "targets" -> JsArr(usableItems.map(_.toJson))
  )
}
