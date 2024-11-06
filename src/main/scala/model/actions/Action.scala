package model.actions

import api.{GameObject, Source, Target}
import model.units.Enemy
import model.units.characters.{Character, MagicCharacter}

/** Trait defining basic action properties and behaviors.
 *
 * Provides basic methods for setting and retrieving the action's name and ID,
 * as well as methods to execute the action based on the type of character or enemy.
 */
trait Action extends GameObject {

  /** Sets the action's name.
   *
   * @param name The name to set for the action.
   */
  def setName(name: String): Unit

  /** @return The name of the action. */
  def getName: String

  /** @return The unique identifier for the action. */
  def getId: String

  /** Executes the action on the target by an enemy.
   *
   * @param enemy The enemy executing the action.
   * @param tgt The target of the action.
   */
  def enemyExecute(enemy: Enemy, tgt: Target): Unit

  /** Executes the action on the target by a normal character.
   *
   * @param character The character executing the action.
   * @param tgt The target of the action.
   */
  def normalCharacterExecute(character: Character, tgt: Target): Unit

  /** Executes the action on the target by a magic character.
   *
   * @param magicCharacter The magic character executing the action.
   * @param tgt The target of the action.
   */
  def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit
}