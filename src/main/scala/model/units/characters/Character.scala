package model.units.characters

import model.items.Item
import model.items.weapons.Weapon
import model.patterns.factory.potions.PotionFactory
import model.patterns.factory.weapon.WeaponFactory
import model.units.Units

import scala.collection.mutable.ArrayBuffer

/**
 * Trait defining additional behavior for character units, including weapons and items.
 *
 * This trait provides the basic methods and properties that all character entities should have, such as
 * managing their weapon and item inventory, calculating their action bar maximum, and equipping different
 * types of weapons.
 */
trait Character extends Units {
  
  protected val compatibleWeaponFactories: List[WeaponFactory]

  protected val compatiblePotionFactories: List[PotionFactory]
  
  def init(): Unit
  
  /**
   * Sets the character's weapon.
   *
   * @param weapon The weapon to be equipped, or `None` to remove the current weapon.
   */
  def setWeapon(weapon: Option[Weapon]): Unit

  /**
   * Sets the character's item inventory.
   *
   * @param itemList The new list of items in the character's inventory.
   */
  def setItemInventory(itemList: ArrayBuffer[Item]): Unit

  /**
   * Gets the character's currently equipped weapon.
   *
   * @return The character's weapon, or `None` if no weapon is equipped.
   */
  def getWeapon: Option[Weapon]

  /**
   * Gets the character's current item inventory.
   *
   * @return The list of items in the character's inventory.
   */
  def getItemInventory: ArrayBuffer[Item]

  /**
   * Calculates the character's action bar maximum, based on their weight and equipped weapon.
   *
   * @return The maximum value of the character's action bar.
   */
  def calculateActionBarMax: Double

  /**
   * Equips the character with a staff-type weapon.
   *
   * @param weapon The staff-type weapon to be equipped.
   */
  def equipStaff(weapon: Weapon): Unit

  /**
   * Equips the character with a wand-type weapon.
   *
   * @param weapon The wand-type weapon to be equipped.
   */
  def equipWand(weapon: Weapon): Unit

  /**
   * Equips the character with a bow-type weapon.
   *
   * @param weapon The bow-type weapon to be equipped.
   */
  def equipBow(weapon: Weapon): Unit

  /**
   * Equips the character with a dagger-type weapon.
   *
   * @param weapon The dagger-type weapon to be equipped.
   */
  def equipDagger(weapon: Weapon): Unit

  /**
   * Equips the character with a sword-type weapon.
   *
   * @param weapon The sword-type weapon to be equipped.
   */
  def equipSword(weapon: Weapon): Unit
}
