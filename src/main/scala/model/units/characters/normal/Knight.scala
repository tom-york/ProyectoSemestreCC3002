package model.units.characters.normal

import model.exceptions.IncompatibleWeapon
import model.items.Item
import model.items.weapons.normal.*
import model.items.weapons.Weapon
import model.panels.IPanel
import model.units.characters.AbstractNormalCharacter

class Knight(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, weaponSlot: Option[Weapon], itemInventory: List[Item]) extends AbstractNormalCharacter(name, healthPoints, defensePoints, weight, panel, weaponSlot, itemInventory) {
  protected val compatibleWeapons: List[Weapon] = List(new Sword(this), new Dagger(this), new Bow(this))

  override def equipStaff(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Knight")

  override def equipWand(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Knight")

  override def equipBow(weapon: Weapon): Unit = {
    this.setWeapon(Some(weapon))
  }

  override def equipDagger(weapon: Weapon): Unit = {
    this.setWeapon(Some(weapon))
  }

  override def equipSword(weapon: Weapon): Unit = {
    this.setWeapon(Some(weapon))
  }
}
