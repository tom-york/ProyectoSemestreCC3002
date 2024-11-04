package model.items.potions.normal

import model.items.potions.AbstractPotion
import model.units.Units
import model.units.characters.{Character, MagicCharacter}

class HealingPotion(name: String) extends AbstractPotion(name) {
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

  override def magicCharacterConsume(character: MagicCharacter): Unit = {
    characterConsume(character)
  }
}
