package model.units.characters.normal

import model.exceptions.IncompatibleWeapon
import model.items.Item
import model.items.weapons.normal.*
import model.items.weapons.Weapon
import model.panels.IPanel
import model.units.characters.AbstractNormalCharacter

/**
 * A class representing a Knight character in the game.
 *
 * Knights are a type of normal character that can equip certain weapons, such as swords, daggers, and bows.
 * They are not compatible with staff or wand weapons.
 *
 * @param name The name of the Knight.
 * @param healthPoints The initial health points of the Knight.
 * @param defensePoints The defense points of the Knight.
 * @param weight The weight of the Knight.
 * @param panel The game panel where the Knight is displayed.
 * @param itemInventory The inventory of items the Knight possesses.
 */
class Knight(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, itemInventory: List[Item]) extends AbstractNormalCharacter(name, healthPoints, defensePoints, weight, panel, itemInventory) {
  protected val compatibleWeapons: List[Weapon] = List(new Sword(), new Dagger(), new Bow())

  /**
   * Throws an IncompatibleWeapon exception when attempting to equip a staff.
   * Knights are not compatible with staff weapons.
   *
   * @param weapon The weapon the Knight is attempting to equip.
   * @throws IncompatibleWeapon if the weapon is a staff.
   */
  override def equipStaff(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Knight")

  /**
   * Throws an IncompatibleWeapon exception when attempting to equip a wand.
   * Knights are not compatible with wand weapons.
   *
   * @param weapon The weapon the Knight is attempting to equip.
   * @throws IncompatibleWeapon if the weapon is a wand.
   */
  override def equipWand(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Knight")

  /**
   * Sets the owner of the bow weapon to the Knight.
   *
   * @param weapon The bow weapon the Knight is equipping.
   */
  override def equipBow(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }

  /**
   * Sets the owner of the dagger weapon to the Knight.
   *
   * @param weapon The dagger weapon the Knight is equipping.
   */
  override def equipDagger(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }

  /**
   * Sets the owner of the sword weapon to the Knight.
   *
   * @param weapon The sword weapon the Knight is equipping.
   */
  override def equipSword(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }
}
