package model.patterns.factory.weapon

import model.items.weapons.Weapon

trait WeaponFactory {
  def apply(): Weapon 
}
