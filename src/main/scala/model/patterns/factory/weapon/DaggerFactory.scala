package model.patterns.factory.weapon

import model.items.weapons.normal.Dagger

object DaggerFactory extends WeaponFactory  {
  override def apply() = new Dagger()
}
