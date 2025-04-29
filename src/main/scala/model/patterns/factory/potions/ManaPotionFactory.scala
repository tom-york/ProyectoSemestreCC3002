package model.patterns.factory.potions

import model.items.potions.magic.ManaPotion

object ManaPotionFactory extends PotionFactory {
  override def apply() = new ManaPotion("ManaPotion")
}
