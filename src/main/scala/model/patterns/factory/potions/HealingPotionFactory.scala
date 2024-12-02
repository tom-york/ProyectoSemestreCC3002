package model.patterns.factory.potions

import model.items.potions.normal.HealingPotion

object HealingPotionFactory extends PotionFactory {
  override def apply() = new HealingPotion("HealingPotion")
}
