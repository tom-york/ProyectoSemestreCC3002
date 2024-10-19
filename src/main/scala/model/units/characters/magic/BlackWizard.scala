package model.units.characters.magic

import model.items.Item
import model.items.weapons.Weapon
import model.units.characters.AbstractMagicCharacter

class BlackWizard(name: String, healthPoints: Int, defensePoints: Int, weight: Int, weaponSlot: Option[Weapon], itemInventory: List[Item], manaPoints: Int) extends AbstractMagicCharacter(name, healthPoints, defensePoints, weight, weaponSlot, itemInventory, manaPoints) {
  
}
