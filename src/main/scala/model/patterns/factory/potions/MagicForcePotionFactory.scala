package model.patterns.factory.potions

import model.items.potions.magic.MagicForcePotion

object MagicForcePotionFactory extends PotionFactory {
  override def apply() = new MagicForcePotion("MagicForcePotion")
}
