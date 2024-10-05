package model.units.Characters.NormalCharacters

import model.items.Item
import model.items.Weapons.Weapon
import model.units.Characters.AbstractCharacter

class Archer(name: String, healthPoints: Int, defensePoints: Int, weight: Int, weaponSlot: Option[Weapon], itemInventory: List[Item]) extends AbstractCharacter(name, healthPoints, defensePoints, weight, weaponSlot, itemInventory) {
  
  val id: String = "Archer"

}
