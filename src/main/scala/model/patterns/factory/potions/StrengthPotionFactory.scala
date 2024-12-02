package model.patterns.factory.potions

import model.items.potions.normal.StrengthPotion

object StrengthPotionFactory extends PotionFactory {
  override def apply() = new StrengthPotion("StrengthPotion")
}
