package model.patterns.factory.weapon

import model.items.weapons.magic.Wand

object WandFactory extends WeaponFactory  {
  override def apply() = new Wand()
}
