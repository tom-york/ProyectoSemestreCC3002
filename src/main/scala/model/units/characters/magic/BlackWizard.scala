package model.units.characters.magic

import model.units.characters.AbstractMagicCharacter
import model.actions.Action
import model.actions.base.*
import model.actions.spells.black.*
import model.actions.usage.*
import model.exceptions.IncompatibleWeapon
import model.items.Item
import model.items.weapons.normal.Dagger
import model.items.weapons.magic.*
import model.items.weapons.Weapon
import model.panels.IPanel

class BlackWizard(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, itemInventory: List[Item], manaPoints: Int) extends AbstractMagicCharacter(name, healthPoints, defensePoints, weight, panel, itemInventory, manaPoints) {
  private val compatibleWeapons: List[Weapon] = List(new Dagger(), new Wand(), new Staff())

  override val actions: List[Action] = List(new Attack(), new Move(), new Consume("Consume", compatibleConsumables), new Equip("Equip", compatibleWeapons), new Meteorite(), new Thunder())

  override def equipStaff(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }

  override def equipWand(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }

  override def equipBow(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Black Wizard")

  override def equipDagger(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }

  override def equipSword(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Black Wizard")
}
