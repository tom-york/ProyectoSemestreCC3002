package model.actions.base

import api.{Source, Target}
import model.actions.AbstractAction
import model.exceptions.*
import model.units.Enemy
import model.units.characters.Character
import spray.json.JsObject
import util.Json.{*, given}

class Attack(name: String = "Attack") extends AbstractAction(name){

  override def characterExecute(character: Character, tgt: Target): Unit = {
    tgt.beAttacked(character.getWeapon.getOrElse(throw new WeaponNotPresent(character)).getTotalAttack)
  }

  override def enemyExecute(enemy: Enemy, tgt: Target): Unit = {
    tgt.beAttacked(enemy.getDp)
  }

  override def id: String = "1" // Identifier for this action

  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "base→attack"
  )
}
