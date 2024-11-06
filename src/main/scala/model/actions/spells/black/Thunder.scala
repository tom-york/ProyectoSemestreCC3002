package model.actions.spells.black

import api.Target
import model.actions.spells.Spell
import model.exceptions.InsufficientManaPoints
import model.units.characters.MagicCharacter
import util.Json.{*, given}

/** Class representing a Thunder spell.
 *
 * Allows a magic character to use the Thunder spell if they have sufficient mana points.
 *
 * @param name The name of the spell.
 * @throws InsufficientManaPoints if the character does not have enough mana points to use the spell.
 */
class Thunder(name: String = "Thunder") extends Spell(name) {

  /** Executes the Thunder spell by a magic character on a target.
   *
   * @param magicCharacter The magic character using the spell.
   * @param tgt The target of the spell.
   */
  override def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit = {
    val currentManaPoints = magicCharacter.getMp
    if (currentManaPoints >= 20) {
      tgt.useThunder(magicCharacter)
      magicCharacter.magicForceReset()
      magicCharacter.setMp(magicCharacter.getMp - 20)
    }
    else throw new InsufficientManaPoints(magicCharacter, "Heal")
  }

  /** @return The unique identifier for the Thunder spell. */
  override def id: String = "4"

  /** @return A JSON representation of the Thunder spell. */
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "spell→black→thunder"
  )
}
