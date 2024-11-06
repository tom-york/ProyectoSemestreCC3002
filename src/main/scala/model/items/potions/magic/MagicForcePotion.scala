package model.items.potions.magic

import model.exceptions.InvalidSourceTarget
import model.items.potions.AbstractPotion
import model.units.characters.{Character, MagicCharacter}

/**
 * A class representing a magic force potion, a type of potion that affects a magic character's magic power.
 *
 * @param name The name of the magic force potion.
 *
 * @constructor Initializes a new magic force potion with the specified name.
 */
class MagicForcePotion(name: String) extends AbstractPotion(name) {

  /**
   * Throws an error if a regular character attempts to consume the magic force potion.
   *
   * @param character The character consuming the magic force potion (throws error for regular characters).
   *
   * @throws InvalidSourceTarget If invoked by a regular character.
   */
  override def characterConsume(character: Character): Unit = {
    throw new InvalidSourceTarget(character.getName, "Magic Force Potion")
  }

  /**
   * Consumes the potion to apply a magic force effect to a magic character.
   *
   * @param magicCharacter The magic character consuming the magic force potion.
   */
  override def magicCharacterConsume(magicCharacter: MagicCharacter): Unit = {
    magicCharacter.magicForcePotionEffect()
  }
}