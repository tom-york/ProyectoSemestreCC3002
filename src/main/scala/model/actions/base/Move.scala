package model.actions.base

import api.Target
import model.actions.AbstractAction
import model.units.Enemy
import model.units.characters.{Character, MagicCharacter}
import util.Json.{*, given}

/** Class representing a move action.
 *
 * Allows a character, magical character, or enemy to move to a specified target.
 *
 * @param name The name of the action.
 */
class Move(name: String = "Move") extends AbstractAction(name) {

  /** Executes a move by a normal character to a target.
   *
   * @param character The character performing the move.
   * @param tgt The target position.
   */
  override def normalCharacterExecute(character: Character, tgt: Target): Unit = {
    tgt.moveUnit(character)
  }

  /** Executes a move by a magic character to a target.
   *
   * @param magicCharacter The magic character performing the move.
   * @param tgt The target position.
   */
  override def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit = {
    tgt.moveUnit(magicCharacter)
  }

  /** Executes a move by an enemy to a target.
   *
   * @param enemy The enemy performing the move.
   * @param tgt The target position.
   */
  override def enemyExecute(enemy: Enemy, tgt: Target): Unit = {
    tgt.moveUnit(enemy)
  }

  /** @return The unique identifier for the move action. */
  override def id: String = "2"

  /** @return A JSON representation of the move action. */
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "base→move"
  )
}
