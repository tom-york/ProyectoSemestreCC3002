package model.units.characters.normal

import model.actions.Action
import model.actions.base.*
import model.actions.usage.*
import model.exceptions.IncompatibleWeapon
import model.items.Item
import model.items.weapons.normal.*
import model.items.weapons.magic.Wand
import model.items.weapons.Weapon
import model.panels.IPanel
import model.units.characters.AbstractNormalCharacter

class Archer(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, weaponSlot: Option[Weapon], itemInventory: List[Item]) extends AbstractNormalCharacter(name, healthPoints, defensePoints, weight, panel, weaponSlot, itemInventory) {
  protected val compatibleWeapons: List[Weapon] = List(new Sword(this), new Bow(this), new Wand(this))

  override def equipStaff(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Archer")

  override def equipWand(weapon: Weapon): Unit = {
    this.setWeapon(Some(weapon))
  }

  override def equipBow(weapon: Weapon): Unit = {
    this.setWeapon(Some(weapon))
  }

  override def equipDagger(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Archer")

  override def equipSword(weapon: Weapon): Unit = {
    this.setWeapon(Some(weapon))
  }
}
