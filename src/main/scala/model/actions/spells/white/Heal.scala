package model.actions.spells.white

import api.Target
import model.actions.spells.Spell
import model.exceptions.InsufficientManaPoints
import model.units.characters.MagicCharacter
import util.Json.{*, given}

/** Class representing a Heal spell.
 *
 * Allows a magic character to heal a target if they have sufficient mana points.
 *
 * @param name The name of the spell.
 * @throws InsufficientManaPoints if the character does not have enough mana points to use the spell.
 */
class Heal(name: String = "Heal") extends Spell(name) {

  /** Executes the Heal spell by a magic character on a target.
   *
   * @param magicCharacter The magic character using the spell.
   * @param tgt The target of the spell.
   */
  override def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit = {
    val currentManaPoints = magicCharacter.getMp
    if (currentManaPoints >= 15) {
      tgt.healCharacter(magicCharacter)
      magicCharacter.magicForceReset()
      magicCharacter.setMp(magicCharacter.getMp - 15)
    }
    else throw new InsufficientManaPoints(magicCharacter, "Heal")
  }

  /** @return The unique identifier for the Heal spell. */
  override def id: String = "5"

  /** @return A JSON representation of the Heal spell. */
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "spell→white→heal"
  )
}

