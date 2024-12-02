package model.patterns.factory.potions

import model.items.potions.Potion

trait PotionFactory {
  def apply(): Potion
}
