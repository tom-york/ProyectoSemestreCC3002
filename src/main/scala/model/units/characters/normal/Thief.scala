package model.units.characters.normal

import model.items.Item
import model.items.weapons.Weapon
import model.units.characters.AbstractNormalCharacter

class Thief(name: String, healthPoints: Int, defensePoints: Int, weight: Int, weaponSlot: Option[Weapon], itemInventory: List[Item]) extends AbstractNormalCharacter(name, healthPoints, defensePoints, weight, weaponSlot, itemInventory) {
  
}
