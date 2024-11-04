package model.items.potions.magic

import model.exceptions.InvalidSourceTarget
import model.items.potions.AbstractPotion
import model.units.Units
import model.units.characters.{Character, MagicCharacter}

class ManaPotion(name: String) extends AbstractPotion(name) {
  override def characterConsume(character: Character): Unit = {
    throw new InvalidSourceTarget(character.getName, "Mana Potion")
  }

  override def magicCharacterConsume(character: MagicCharacter): Unit = {
    val currentMP: Int  = character.getMp
    val maxMP: Int  = character.getMaxMp
    val calculateEffects: Float = currentMP + Math.round(maxMP * 0.3)
    if (Math.round(calculateEffects) < maxMP) {
      character.setMp(Math.round(calculateEffects))
    }
    else {
      character.setMp(maxMP)
    }
  }
}
