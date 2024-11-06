package model.items.potions.magic

import model.exceptions.InvalidSourceTarget
import model.items.potions.AbstractPotion
import model.units.characters.{Character, MagicCharacter}

class MagicForcePotion(name: String) extends AbstractPotion(name) {
  override def characterConsume(character: Character): Unit = {
    throw new InvalidSourceTarget(character.getName, "Magic Force Potion")
  }

  override def magicCharacterConsume(magicCharacter: MagicCharacter): Unit = {
    magicCharacter.magicForcePotionEffect()
  }
}
