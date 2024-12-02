package model.units.characters.normal

import model.actions.Action
import model.actions.base.*
import model.actions.usage.*
import model.exceptions.IncompatibleWeapon
import model.items.Item
import model.items.potions.normal.StrengthPotion
import model.items.weapons.normal.*
import model.items.weapons.magic.Wand
import model.items.weapons.Weapon
import model.panels.IPanel
import model.patterns.factory.potions.{HealingPotionFactory, PotionFactory, StrengthPotionFactory}
import model.patterns.factory.weapon.{BowFactory, SwordFactory, WandFactory, WeaponFactory}
import model.units.characters.AbstractNormalCharacter

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * Class representing an Archer character, extending `AbstractNormalCharacter`.
 *
 * This class defines the specific properties and behavior for the Archer character type, including
 * the compatible weapons they can equip.
 *
 * @param name The name of the Archer.
 * @param healthPoints The maximum health points of the Archer.
 * @param defensePoints The defense points of the Archer.
 * @param weight The weight of the Archer.
 * @param panel The panel associated with the Archer.
 * @param itemInventory The initial list of items in the Archer's inventory.
 */
class Archer(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, itemInventory: ArrayBuffer[Item]) extends AbstractNormalCharacter(name, healthPoints, defensePoints, weight, panel, itemInventory) {

  protected val compatibleWeaponFactories: List[WeaponFactory] = List(SwordFactory, BowFactory, WandFactory)

  protected val compatiblePotionFactories: List[PotionFactory] = List(HealingPotionFactory, StrengthPotionFactory)

  protected val compatibleWeapons: List[Weapon] = List(new Sword(), new Bow(), new Wand())

  /**
   * Throws an `IncompatibleWeapon` exception, as Archers cannot equip staff-type weapons.
   *
   * @param weapon The staff-type weapon the Archer is trying to equip.
   * @throws IncompatibleWeapon
   */
  override def equipStaff(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Archer")

  /**
   * Equips the Archer with a wand-type weapon.
   *
   * @param weapon The wand-type weapon to be equipped.
   */
  override def equipWand(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }

  /**
   * Equips the Archer with a bow-type weapon.
   *
   * @param weapon The bow-type weapon to be equipped.
   */
  override def equipBow(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }

  /**
   * Throws an `IncompatibleWeapon` exception, as Archers cannot equip dagger-type weapons.
   *
   * @param weapon The dagger-type weapon the Archer is trying to equip.
   * @throws IncompatibleWeapon
   */
  override def equipDagger(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Archer")

  /**
   * Equips the Archer with a sword-type weapon.
   *
   * @param weapon The sword-type weapon to be equipped.
   */
  override def equipSword(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }
}
