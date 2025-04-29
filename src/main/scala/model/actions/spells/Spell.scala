package model.actions.spells

import api.Target
import model.actions.AbstractAction
import model.exceptions.InvalidSourceAction
import model.units.Enemy
import model.units.characters.Character

/** Abstract class representing an action involving a spell.
 *
 * Spells are actions that can only be executed by characters with magical abilities.
 * Non-magical characters and enemies cannot perform these actions and will throw an error.
 *
 * @param name The name of the spell.
 */
abstract class Spell(name: String) extends AbstractAction(name) {

  /** Attempts to execute the spell by a normal character.
   *
   * @param character The character attempting the action.
   * @param tgt The target of the action.
   * @throws InvalidSourceAction if a normal character attempts to execute the spell.
   */
  override def normalCharacterExecute(character: Character, tgt: Target): Unit = {
    throw new InvalidSourceAction(character.getName, this.getName)
  }

  /** Attempts to execute the spell by an enemy.
   *
   * @param enemy The enemy attempting the action.
   * @param tgt The target of the action.
   * @throws InvalidSourceAction if an enemy attempts to execute the spell.
   */
  override def enemyExecute(enemy: Enemy, tgt: Target): Unit = {
    throw new InvalidSourceAction(enemy.getName, this.getName)
  }

}
