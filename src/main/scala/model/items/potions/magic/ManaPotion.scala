package model.items.potions.magic

import model.exceptions.InvalidSourceTarget
import model.items.potions.AbstractPotion
import model.units.characters.{Character, MagicCharacter}

/**
 * A class representing a mana potion, a type of potion that restores a magic character's mana.
 *
 * @param name The name of the mana potion.
 *
 * @constructor Initializes a new mana potion with the specified name.
 */
class ManaPotion(name: String) extends AbstractPotion(name) {

  /**
   * Throws an error if a regular character attempts to consume the mana potion.
   *
   * @param character The character consuming the mana potion (throws error for regular characters).
   *
   * @throws InvalidSourceTarget If invoked by a regular character.
   */
  override def characterConsume(character: Character): Unit = {
    throw new InvalidSourceTarget(character.getName, "Mana Potion")
  }

  /**
   * Consumes the potion to restore a magic character's mana by 30% of their maximum MP, 
   * but not exceeding the maximum MP.
   *
   * @param magicCharacter The magic character consuming the mana potion.
   */
  override def magicCharacterConsume(magicCharacter: MagicCharacter): Unit = {
    val currentMP: Int  = magicCharacter.getMp
    val maxMP: Int  = magicCharacter.getMaxMp
    val calculateEffects: Float = currentMP + Math.round(maxMP * 0.3)
    if (Math.round(calculateEffects) < maxMP) {
      magicCharacter.setMp(Math.round(calculateEffects))
    }
    else {
      magicCharacter.setMp(maxMP)
    }
  }
}

