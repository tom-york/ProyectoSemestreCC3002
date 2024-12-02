package model.units.characters.normal

import model.actions.Action
import model.actions.base.*
import model.actions.usage.*
import model.exceptions.IncompatibleWeapon
import model.items.Item
import model.items.weapons.normal.*
import model.items.weapons.Weapon
import model.panels.IPanel
import model.patterns.factory.potions.{HealingPotionFactory, PotionFactory, StrengthPotionFactory}
import model.patterns.factory.weapon.{DaggerFactory, SwordFactory, WeaponFactory}
import model.units.characters.AbstractNormalCharacter

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * A class representing a Thief character in the game.
 *
 * Thieves are a type of normal character that can equip certain weapons, such as swords and daggers.
 * They are not compatible with staff, wand, or bow weapons.
 *
 * @param name The name of the Thief.
 * @param healthPoints The initial health points of the Thief.
 * @param defensePoints The defense points of the Thief.
 * @param weight The weight of the Thief.
 * @param panel The game panel where the Thief is displayed.
 * @param itemInventory The inventory of items the Thief possesses.
 */
class Thief(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, itemInventory: ArrayBuffer[Item]) extends AbstractNormalCharacter(name, healthPoints, defensePoints, weight, panel, itemInventory) {

  protected val compatibleWeaponFactories: List[WeaponFactory] = List(SwordFactory, DaggerFactory)

  protected val compatiblePotionFactories: List[PotionFactory] = List(HealingPotionFactory, StrengthPotionFactory)

  override def init(): Unit = {
    for (x <- 0 until 2) {
      itemInventory += compatibleWeaponFactories(Random.between(0,2))()
    }
    for (x <- 0 until 2) {
      itemInventory += compatiblePotionFactories(Random.between(0,2))()
    }
  }
  
  protected val compatibleWeapons: List[Weapon] = List(new Sword(), new Dagger())

  /**
   * Throws an IncompatibleWeapon exception when attempting to equip a staff.
   * Thieves are not compatible with staff weapons.
   *
   * @param weapon The weapon the Thief is attempting to equip.
   * @throws IncompatibleWeapon if the weapon is a staff.
   */
  override def equipStaff(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Thief")

  /**
   * Throws an IncompatibleWeapon exception when attempting to equip a wand.
   * Thieves are not compatible with wand weapons.
   *
   * @param weapon The weapon the Thief is attempting to equip.
   * @throws IncompatibleWeapon if the weapon is a wand.
   */
  override def equipWand(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Thief")

  /**
   * Throws an IncompatibleWeapon exception when attempting to equip a bow.
   * Thieves are not compatible with bow weapons.
   *
   * @param weapon The weapon the Thief is attempting to equip.
   * @throws IncompatibleWeapon if the weapon is a bow.
   */
  override def equipBow(weapon: Weapon): Unit = throw new IncompatibleWeapon(weapon, "Thief")

  /**
   * Sets the owner of the dagger weapon to the Thief.
   *
   * @param weapon The dagger weapon the Thief is equipping.
   */
  override def equipDagger(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }

  /**
   * Sets the owner of the sword weapon to the Thief.
   *
   * @param weapon The sword weapon the Thief is equipping.
   */
  override def equipSword(weapon: Weapon): Unit = {
    weapon.setOwner(this)
  }
}
