package model.actions.spells.black

import api.Target
import model.actions.spells.Spell
import model.exceptions.InsufficientManaPoints
import model.units.characters.MagicCharacter
import util.Json.{*, given}

/** Class representing a Meteorite spell.
 *
 * Allows a magic character to use the Meteorite spell if they have sufficient mana points.
 *
 * @param name The name of the spell.
 * @throws InsufficientManaPoints if the character does not have enough mana points to use the spell.
 */
class Meteorite(name: String = "Meteorite") extends Spell(name) {

  /** Executes the Meteorite spell by a magic character on a target.
   *
   * @param magicCharacter The magic character using the spell.
   * @param tgt The target of the spell.
   */
  override def magicCharacterExecute(magicCharacter: MagicCharacter, tgt: Target): Unit = {
    val currentManaPoints = magicCharacter.getMp
    if (currentManaPoints >= 50) {
      tgt.useMeteorite(magicCharacter)
      magicCharacter.magicForceReset()
      magicCharacter.setMp(magicCharacter.getMp - 50)
    }
    else throw new InsufficientManaPoints(magicCharacter, "Heal")
  }

  /** @return The unique identifier for the Meteorite spell. */
  override def id: String = "3"

  /** @return A JSON representation of the Meteorite spell. */
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "spell→black→meteorite"
  )
}
