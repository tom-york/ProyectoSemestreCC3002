package model.items.potions.normal

import model.items.potions.AbstractPotion
import model.units.Units
import model.units.characters.{Character, MagicCharacter}

/**
 * A class representing a healing potion, a type of potion that heals a character's health.
 *
 * @param name The name of the healing potion.
 *
 * @constructor Initializes a new healing potion with the specified name.
 */
class HealingPotion(name: String) extends AbstractPotion(name) {

  /**
   * Consumes the potion to heal a character.
   * Heals a character by 20% of their maximum HP, but not exceeding the maximum HP.
   *
   * @param character The character consuming the healing potion.
   */
  override def characterConsume(character: Character): Unit = {
    val currentHP: Int  = character.getHp
    val maxHP: Int  = character.getMaxHp
    val calculateEffects: Float = currentHP + Math.round(maxHP * 0.2)
    if (Math.round(calculateEffects) < maxHP) {
      character.setHp(Math.round(calculateEffects))
    }
    else {
      character.setHp(maxHP)
    }
  }

  /**
   * Consumes the potion to heal a magic character.
   * Calls the `characterConsume` method for magic characters.
   *
   * @param magicCharacter The magic character consuming the healing potion.
   */
  override def magicCharacterConsume(magicCharacter: MagicCharacter): Unit = {
    characterConsume(magicCharacter)
  }
}

