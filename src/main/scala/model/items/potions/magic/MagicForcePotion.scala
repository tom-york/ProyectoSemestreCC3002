package model.items.potions.magic

import model.exceptions.InvalidSourceTarget
import model.items.potions.AbstractPotion
import model.units.Units
import model.units.characters.MagicCharacter
import util.Json.{*, given}

class MagicForcePotion(name: String) extends AbstractPotion(name) {
  override def unitConsume(unit: Units): Unit = {
    throw new InvalidSourceTarget(unit.getName, "Magic Force Potion")
  }

  override def unitMagicConsume(character: MagicCharacter): Unit = {
    character.magicForcePotionEffect()
  }
}
