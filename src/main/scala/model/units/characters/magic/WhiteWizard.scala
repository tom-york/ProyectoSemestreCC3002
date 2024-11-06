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

/**
 * A class representing a White Wizard character in the game.
 *
 * White Wizards are a type of magic character that can equip certain weapons, such as bows, wands, and staves.
 * They are not compatible with dagger or sword weapons.
 *
 * @param name The name of the White Wizard.
 * @param healthPoints The initial health points of the White Wizard.
 * @param defensePoints The defense points of the White Wizard.
 * @param weight The weight of the White Wizard.
 * @param panel The game panel where the White Wizard is displayed.
 * @param itemInventory The inventory of items the White Wizard possesses.
 * @param manaPoints The initial mana points of the White Wizard.
 */
class WhiteWizard(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, itemInventory: List[Item], manaPoints: Int) extends AbstractMagicCharacter(name, healthPoints, defensePoints, weight, panel, itemInventory, manaPoints) {
  private val compatibleWeapons: List[Weapon] = List(new Bow(), new Wand(), new Staff())

  override val actions: List[Action] = List(new Attack(), new Move(), new Consume("Consume", compatibleConsumables), new Equip("Equip", compatibleWeapons), new Heal(), new Purify())

  /**
   * Sets the owner of the staff weapon to the White Wizard.
   *
   * @param weapon The staff weapon the White Wizard is equipping.
   */
  override def equipStaff(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }

  /**
   * Sets the owner of the wand weapon to the White Wizard.
   *
   * @param weapon The wand weapon the White Wizard is equipping.
   */
  override def equipWand(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }

  /**
   * Sets the owner of the bow weapon to the White Wizard.
   *
   * @param weapon The bow weapon the White Wizard is equipping.
   */
  override def equipBow(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }

  /**
   * Throws an IncompatibleWeapon exception when attempting to equip a dagger.
   * White Wizards are not compatible with dagger weapons.
   *
   * @param weapon The weapon the White Wizard is attempting to equip.
   * @throws IncompatibleWeapon if the weapon is a dagger.
   */
  override def equipDagger(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "White Wizard")

  /**
   * Throws an IncompatibleWeapon exception when attempting to equip a sword.
   * White Wizards are not compatible with sword weapons.
   *
   * @param weapon The weapon the White Wizard is attempting to equip.
   * @throws IncompatibleWeapon if the weapon is a sword.
   */
  override def equipSword(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "White Wizard")
}