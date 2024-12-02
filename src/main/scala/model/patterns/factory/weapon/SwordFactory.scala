package model.patterns.factory.weapon

import model.items.weapons.normal.Sword

object SwordFactory extends WeaponFactory  {
  override def apply() = new Sword()
}
