package model.units.characters.magic

import model.items.Item
import model.items.weapons.Weapon
import model.units.characters.AbstractMagicCharacter
import model.actions.Action
import model.actions.base.*
import model.actions.spells.black.*
import model.actions.usage.*
import model.items.potions.Potion
import model.items.potions.magic.*
import model.items.potions.normal.*
import model.items.weapons.normal.Dagger
import model.items.weapons.magic.*


class BlackWizard(name: String, healthPoints: Int, defensePoints: Int, weight: Int, weaponSlot: Option[Weapon], itemInventory: List[Item], manaPoints: Int) extends AbstractMagicCharacter(name, healthPoints, defensePoints, weight, weaponSlot, itemInventory, manaPoints) {
  private val compatibleConsumables: List[Potion] = List(new HealingPotion("HealPot"), new StrengthPotion("StrengthPot"), new ManaPotion("ManaPot"), new MagicForcePotion("MagicPot"))
  private val compatibleWeapons: List[Weapon] = List(new Dagger(this), new Wand(this), new Staff(this))

  override val actions: List[Action] = List(new Attack(), new Move(), new Consume("Consume", compatibleConsumables), new Equip("Equip", compatibleWeapons), new Meteorite(), new Thunder())
}
