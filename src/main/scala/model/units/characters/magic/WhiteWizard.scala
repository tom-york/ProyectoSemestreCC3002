package model.units.characters.magic

import model.units.characters.AbstractMagicCharacter
import model.actions.Action
import model.actions.base.*
import model.actions.spells.white.*
import model.actions.usage.*
import model.exceptions.IncompatibleWeapon
import model.items.Item
import model.items.weapons.normal.Bow
import model.items.weapons.magic.*
import model.items.weapons.Weapon
import model.panels.IPanel

class WhiteWizard(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, weaponSlot: Option[Weapon], itemInventory: List[Item], manaPoints: Int) extends AbstractMagicCharacter(name, healthPoints, defensePoints, weight, panel, weaponSlot, itemInventory, manaPoints) {
  private val compatibleWeapons: List[Weapon] = List(new Bow(this), new Wand(this), new Staff(this))

  override val actions: List[Action] = List(new Attack(), new Move(), new Consume("Consume", compatibleConsumables), new Equip("Equip", compatibleWeapons), new Heal(), new Purify())

  override def equipStaff(weapon: Weapon): Unit = {
    this.setWeapon(Some(weapon))
  }

  override def equipWand(weapon: Weapon): Unit = {
    this.setWeapon(Some(weapon))
  }

  override def equipBow(weapon: Weapon): Unit = {
    this.setWeapon(Some(weapon))
  }

  override def equipDagger(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "White Wizard")

  override def equipSword(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "White Wizard")
}
