package model.items.potions.normal

import model.items.potions.AbstractPotion
import model.units.Units
import model.units.characters.{Character, MagicCharacter}

/**
 * A class representing a strength potion, a type of potion that increases a character's defense points.
 *
 * @param name The name of the strength potion.
 *
 * @constructor Initializes a new strength potion with the specified name.
 */
class StrengthPotion(name: String) extends AbstractPotion(name) {

  /**
   * Consumes the potion to increase the character's defense points by 15%.
   *
   * @param character The character consuming the strength potion.
   */
  override def characterConsume(character: Character): Unit = {
    val multiplier: Float = 1.15
    character.setDp(Math.round(character.getDp * multiplier))
  }

  /**
   * Consumes the potion to increase the magic character's defense points.
   * Calls the `characterConsume` method for magic characters.
   *
   * @param magicCharacter The magic character consuming the strength potion.
   */
  override def magicCharacterConsume(magicCharacter: MagicCharacter): Unit = {
    characterConsume(magicCharacter)
  }
}

