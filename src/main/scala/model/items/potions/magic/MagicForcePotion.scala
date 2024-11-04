package model.items.potions.magic

import model.exceptions.InvalidSourceTarget
import model.items.potions.AbstractPotion
import model.units.Units
import model.units.characters.{Character, MagicCharacter}
import util.Json.{*, given}

class MagicForcePotion(name: String) extends AbstractPotion(name) {
  override def characterConsume(character: Character): Unit = {
    throw new InvalidSourceTarget(character.getName, "Magic Force Potion")
  }

  override def magicCharacterConsume(character: MagicCharacter): Unit = {
    character.magicForcePotionEffect()
  }
}
