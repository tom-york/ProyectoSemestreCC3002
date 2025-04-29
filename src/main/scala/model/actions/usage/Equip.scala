package model.actions.usage

import api.Target
import model.exceptions.InvalidSourceAction
import model.items.weapons.Weapon
import model.units.Enemy
import model.units.characters.{Character, MagicCharacter}
import util.Json.{*, given}

/** Class representing an action for equipping weapons.
 *
 * Allows a character or magic character to equip a weapon from the usable items list.
 *
 * @param name The name of the action.
 * @param usableItems The list of weapons that can be equipped by this action.
 */
class Equip(name: String = "Equip", usableItems: List[Weapon]) extends UsageAction(name, usableItems) {

  /** Executes the equip action by a normal character on the target.
   *
   * @param character The character performing the action.
   * @param tgt The target of the action.
   */
  override def normalCharacterExecute(character: Character, tgt: Target): Unit = {
    tgt.equipWeapon(character)
  }

  /** Executes the equip action by a magic character on the target.
   *
   * @param magicCharacter The magic character performing the action.
   * @param tgt The target of the action.
   */
  override def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit = {
    normalCharacterExecute(magicCharacter, tgt)
  }

  /** @return The unique identifier for the equip action. */
  override def id: String = "8"

  /** @return A JSON representation of the equip action, including the list of usable items. */
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "usage→equip",
    "targets" -> JsArr(usableItems.map(_.toJson))
  )
}