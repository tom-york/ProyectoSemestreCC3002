package model.units.Characters.NormalCharacters

import model.items.Item
import model.items.Weapons.Weapon
import model.units.Characters.AbstractCharacter

class Knight(name: String, healthPoints: Int, defensePoints: Int, weight: Int, weaponSlot: Option[Weapon], itemInventory: List[Item]) extends AbstractCharacter(name, healthPoints, defensePoints, weight, weaponSlot, itemInventory) {
  
}
