package model.units.characters
import model.items.Item
import model.items.potions.Potion
import model.items.potions.normal.*
import model.items.weapons.Weapon

abstract class AbstractNormalCharacter(name: String, healthPoints: Int, defensePoints: Int, weight: Int, weaponSlot: Option[Weapon], itemInventory: List[Item]) extends AbstractCharacter(name, healthPoints, defensePoints, weight, weaponSlot, itemInventory) {

  protected val compatibleConsumables: List[Potion] = List(new HealingPotion("HealPot"), new StrengthPotion("StrengthPot"))

}
