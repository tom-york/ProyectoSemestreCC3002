package model.items.potions.normal

import model.items.potions.AbstractPotion
import model.units.Units
import model.units.characters.{Character, MagicCharacter}

class StrengthPotion(name: String) extends AbstractPotion(name) {
  override def characterConsume(character: Character): Unit = {
    val multiplier: Float = 1.15
    character.setDp(Math.round(character.getDp * multiplier))
  }

  override def magicCharacterConsume(magicCharacter: MagicCharacter): Unit = {
    characterConsume(magicCharacter)
  }
}
