package model.units.Characters.MagicCharacters

import model.items.Item
import model.items.Weapons.Weapon
import model.units.Characters.AbstractMagicCharacter

class BlackWizard(name: String, healthPoints: Int, defensePoints: Int, weight: Int, weaponSlot: Option[Weapon], itemInventory: List[Item], manaPoints: Int) extends AbstractMagicCharacter(name, healthPoints, defensePoints, weight, weaponSlot, itemInventory, manaPoints) {
  
  override def id: String = "BlackWizard" // Identifier for this character
  
}
