package model.actions.spells.white

import api.Target
import model.actions.spells.Spell
import model.exceptions.InsufficientManaPoints
import model.units.characters.MagicCharacter
import util.Json.{*, given}

/** Class representing a Purify spell.
 *
 * Allows a magic character to purify an enemy target if they have sufficient mana points.
 *
 * @param name The name of the spell.
 * @throws InsufficientManaPoints if the character does not have enough mana points to use the spell.
 */
class Purify(name: String = "Purify") extends Spell(name) {

  /** Executes the Purify spell by a magic character on a target.
   *
   * @param magicCharacter The magic character using the spell.
   * @param tgt The target of the spell.
   */
  override def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit = {
    val currentManaPoints = magicCharacter.getMp
    if (currentManaPoints >= 25) {
      tgt.purifyEnemy(magicCharacter)
      magicCharacter.magicForceReset()
      magicCharacter.setMp(magicCharacter.getMp - 25)
    }
    else throw new InsufficientManaPoints(magicCharacter, "Purify")
  }

  /** @return The unique identifier for the Purify spell. */
  override def id: String = "6"

  /** @return A JSON representation of the Purify spell. */
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "spell→white→purify"
  )
}
