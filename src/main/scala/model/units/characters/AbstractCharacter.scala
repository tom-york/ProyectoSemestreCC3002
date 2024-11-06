package model.units.characters

import model.exceptions.{DefeatedTarget, InvalidActionTarget, WeaponNotPresent}
import model.items.Item
import model.items.weapons.Weapon
import model.panels.IPanel
import model.units.AbstractUnit
import util.Json.{*, given}

/**
 * Abstract class for characters, implementing the `Character` trait and adding weapon and item inventory.
 *
 * This class provides the base functionality for character entities in the game, including managing their
 * health, defense, weight, and panel. It also handles the character's weapon and item inventory.
 *
 * @param name The name of the character.
 * @param healthPoints The maximum health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param panel The panel associated with the character.
 * @param itemInventory The initial list of items in the character's inventory.
 */
abstract class AbstractCharacter(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, private var itemInventory: List[Item]) extends AbstractUnit(name, healthPoints, defensePoints, weight, panel) with Character {

  protected var weaponSlot: Option[Weapon] = None

  /**
   * Sets the character's weapon.
   *
   * @param weapon The weapon to be equipped, or `None` to remove the current weapon.
   */
  def setWeapon(weapon: Option[Weapon]): Unit = {
    weaponSlot = weapon
  }

  /**
   * Gets the character's currently equipped weapon.
   *
   * @return The character's weapon, or `None` if no weapon is equipped.
   */
  def getWeapon: Option[Weapon] = weaponSlot

  /**
   * Sets the character's item inventory.
   *
   * @param itemList The new list of items in the character's inventory.
   */
  def setItemInventory(itemList: List[Item]): Unit = {
    itemInventory = itemList
  }

  /**
   * Gets the character's current item inventory.
   *
   * @return The list of items in the character's inventory.
   */
  def getItemInventory: List[Item] = itemInventory

  /**
   * Gets the total damage the character can deal, based on their equipped weapon.
   *
   * @throws WeaponNotPresent If the character does not have a weapon equipped.
   * @return The attack points of the character's equipped weapon.
   */
  override def getTotalDamage: Int = weaponSlot.getOrElse(throw new WeaponNotPresent(this)).getAttackPoints

  /**
   * Calculates the character's action bar maximum, adding half the weight of the equipped weapon.
   *
   * @return The maximum value of the character's action bar.
   */
  def calculateActionBarMax: Double = {
    if (weaponSlot.isDefined) {
      weight + 0.5 * weaponSlot.get.getWeight
    } else weight
  }

  /**
   * Serializes the character's attributes and inventory to a JSON object.
   *
   * @return A JSON object representing the character's data.
   */
  override def toJson: JsObj = JsObj(
    "id" -> this.id,
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> getName),
      JsObj("name" -> "hp", "value" -> getHp.toString),
      JsObj("name" -> "dp", "value" -> getDp.toString),
      JsObj("name" -> "weight", "value" -> getWeight.toString),
    ),
    "img" -> "mockImage.gif"
  )

  /**
   * Heals the character by a percentage of their maximum health points, plus a fraction of the healing character's magic damage.
   *
   * @param magicCharacter The magic character performing the healing.
   * @throws DefeatedTarget If the character's health points are already 0.
   */
  override def healCharacter(magicCharacter: MagicCharacter): Unit = {
    if (getHp == 0) {
      throw new DefeatedTarget(this)
    }
    else {
      val healingPercentage: Float = 0.2
      val magicDamageFraction: Float = magicCharacter.getMagicDamage / 4
      val healingTotal: Int = getHp + Math.round((getMaxHp * healingPercentage) + magicDamageFraction)
      if (healingTotal < getMaxHp) {
        setHp(healingTotal)
      }
      else {
        setHp(getMaxHp)
      }
    }
  }

  /**
   * Throws an `InvalidActionTarget` exception, as the `purifyEnemy` action is not valid for a normal character.
   *
   * @param magicCharacter The magic character attempting to purify the enemy.
   * @throws InvalidActionTarget()
   */
  override def purifyEnemy(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Character", "Purify")
  }
}
