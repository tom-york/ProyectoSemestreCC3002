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

/**
 * A class representing a Black Wizard character in the game.
 *
 * Black Wizards are a type of magic character that can equip certain weapons, such as daggers, wands, and staves.
 * They are not compatible with bow or sword weapons.
 *
 * @param name The name of the Black Wizard.
 * @param healthPoints The initial health points of the Black Wizard.
 * @param defensePoints The defense points of the Black Wizard.
 * @param weight The weight of the Black Wizard.
 * @param panel The game panel where the Black Wizard is displayed.
 * @param itemInventory The inventory of items the Black Wizard possesses.
 * @param manaPoints The initial mana points of the Black Wizard.
 */
class BlackWizard(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, itemInventory: List[Item], manaPoints: Int) extends AbstractMagicCharacter(name, healthPoints, defensePoints, weight, panel, itemInventory, manaPoints) {
  private val compatibleWeapons: List[Weapon] = List(new Dagger(), new Wand(), new Staff())

  override val actions: List[Action] = List(new Attack(), new Move(), new Consume("Consume", compatibleConsumables), new Equip("Equip", compatibleWeapons), new Meteorite(), new Thunder())

  /**
   * Sets the owner of the staff weapon to the Black Wizard.
   *
   * @param weapon The staff weapon the Black Wizard is equipping.
   */
  override def equipStaff(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }

  /**
   * Sets the owner of the wand weapon to the Black Wizard.
   *
   * @param weapon The wand weapon the Black Wizard is equipping.
   */
  override def equipWand(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }

  /**
   * Throws an IncompatibleWeapon exception when attempting to equip a bow.
   * Black Wizards are not compatible with bow weapons.
   *
   * @param weapon The weapon the Black Wizard is attempting to equip.
   * @throws IncompatibleWeapon if the weapon is a bow.
   */
  override def equipBow(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Black Wizard")

  /**
   * Sets the owner of the dagger weapon to the Black Wizard.
   *
   * @param weapon The dagger weapon the Black Wizard is equipping.
   */
  override def equipDagger(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }

  /**
   * Throws an IncompatibleWeapon exception when attempting to equip a sword.
   * Black Wizards are not compatible with sword weapons.
   *
   * @param weapon The weapon the Black Wizard is attempting to equip.
   * @throws IncompatibleWeapon if the weapon is a sword.
   */
  override def equipSword(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Black Wizard")
}