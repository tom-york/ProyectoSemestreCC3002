package model.items.potions.magic

import model.exceptions.InvalidSourceTarget
import model.items.potions.AbstractPotion
import model.units.Units
import model.units.characters.{Character, MagicCharacter}

class ManaPotion(name: String) extends AbstractPotion(name) {
  override def characterConsume(character: Character): Unit = {
    throw new InvalidSourceTarget(character.getName, "Mana Potion")
  }

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
