package model.patterns.factory.weapon

import model.items.weapons.normal.Bow

object BowFactory extends WeaponFactory  {
  override def apply() = new Bow()
}
