package model.patterns.factory.weapon

import model.items.weapons.magic.Staff

object StaffFactory extends WeaponFactory {
  override def apply() = new Staff()
}
