package model.items.Potions.NormalPotions

import model.items.Potions.AbstractPotion

class HealingPotion(name: String) extends AbstractPotion(name) {

  override def id: String = "HealingPotion" // Identifier for this potion
  
}
