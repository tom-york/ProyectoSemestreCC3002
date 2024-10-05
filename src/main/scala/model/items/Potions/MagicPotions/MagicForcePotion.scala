package model.items.Potions.MagicPotions

import model.items.Potions.AbstractPotion
import util.Json.{*, given}

class MagicForcePotion(name: String) extends AbstractPotion(name) {

  override def id: String = "MagicForcePotion"

}
