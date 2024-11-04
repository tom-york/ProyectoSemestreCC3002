package model.units.characters.normal

import model.items.Item
import model.items.weapons.normal.*
import model.items.weapons.Weapon
import model.panels.IPanel
import model.units.characters.AbstractNormalCharacter

class Knight(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, weaponSlot: Option[Weapon], itemInventory: List[Item]) extends AbstractNormalCharacter(name, healthPoints, defensePoints, weight, panel, weaponSlot, itemInventory) {
  protected val compatibleWeapons: List[Weapon] = List(new Sword(this), new Dagger(this), new Bow(this))
}
