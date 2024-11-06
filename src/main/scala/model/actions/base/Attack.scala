package model.actions.base

import api.{Source, Target}
import model.actions.AbstractAction
import model.exceptions.*
import model.units.Enemy
import model.units.characters.*
import spray.json.JsObject
import util.Json.{*, given}

/** Class representing a basic attack action.
 *
 * An action that allows a character, magical character, or enemy to attack a target.
 *
 * @param name The name of the action.
 */
class Attack(name: String = "Attack") extends AbstractAction(name) {

  /** Executes an attack by a normal character on a target.
   *
   * @param character The character performing the attack.
   * @param tgt The target being attacked.
   */
  override def normalCharacterExecute(character: Character, tgt: Target): Unit = {
    tgt.beAttacked(character.getTotalDamage)
  }

  /** Executes an attack by a magic character on a target.
   *
   * @param magicCharacter The magic character performing the attack.
   * @param tgt The target being attacked.
   */
  override def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit = {
    tgt.beAttacked(magicCharacter.getTotalDamage)
  }

  /** Executes an attack by an enemy on a target.
   *
   * @param enemy The enemy performing the attack.
   * @param tgt The target being attacked.
   */
  override def enemyExecute(enemy: Enemy, tgt: Target): Unit = {
    tgt.beAttacked(enemy.getTotalDamage)
  }

  /** @return The unique identifier for the attack action. */
  override def id: String = "1"

  /** @return A JSON representation of the attack action. */
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "base→attack"
  )
}
