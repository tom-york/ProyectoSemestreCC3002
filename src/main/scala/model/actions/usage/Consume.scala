package model.actions.usage

import api.Target
import model.items.potions.Potion
import model.units.characters.{Character, MagicCharacter}
import util.Json.{*, given}

/** Class representing an action for consuming potions.
 *
 * Allows a character or magic character to consume a potion from the usable items list.
 *
 * @param name The name of the action.
 * @param usableItems The list of potions that can be consumed by this action.
 */
class Consume(name: String = "Consume", usableItems: List[Potion]) extends UsageAction(name, usableItems) {

  /** Executes the consumption action by a normal character on the target.
   *
   * @param character The character performing the action.
   * @param tgt The target of the action.
   */
  override def normalCharacterExecute(character: Character, tgt: Target): Unit = {
    tgt.characterConsume(character)
  }

  /** Executes the consumption action by a magic character on the target.
   *
   * @param magicCharacter The magic character performing the action.
   * @param tgt The target of the action.
   */
  override def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit = {
    tgt.magicCharacterConsume(magicCharacter)
  }

  /** @return The unique identifier for the consume action. */
  override def id: String = "7"

  /** @return A JSON representation of the consume action, including the list of usable items. */
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "usage→consume",
    "targets" -> JsArr(usableItems.map(_.toJson))
  )
}

