package model.units.characters

import api.Target
import model.actions.Action
import model.exceptions.{InsufficientHP, WeaponNotPresent}
import model.items.Item
import model.items.weapons.Weapon
import model.items.potions.Potion
import model.items.potions.magic.*
import model.items.potions.normal.*
import model.panels.IPanel
import util.Json.{*, given}
import scala.collection.mutable.ArrayBuffer

/**
 * Abstract class for magic characters, extending `AbstractCharacter` and adding mana points.
 *
 * This class provides the base functionality for magic-focused character entities in the game, including managing their
 * mana points and magic-based abilities.
 *
 * @param name The name of the magic character.
 * @param healthPoints The maximum health points of the magic character.
 * @param defensePoints The defense points of the magic character.
 * @param weight The weight of the magic character.
 * @param panel The panel associated with the magic character.
 * @param itemInventory The initial list of items in the magic character's inventory.
 * @param maxManaPoints The maximum mana points of the magic character.
 */
abstract class AbstractMagicCharacter(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, itemInventory: ArrayBuffer[Item], private var maxManaPoints: Int) extends AbstractCharacter(name, healthPoints, defensePoints, weight, panel, itemInventory) with MagicCharacter {

  private var manaPoints: Int = maxManaPoints

  private var magicForceMultiplier: Float = 1.0

  /**
   * Sets the magic character's mana points.
   *
   * @param manaP The new value for the magic character's mana points.
   * @throws IllegalArgumentException if the new mana points value is negative or exceeds the maximum.
   */
  override def setMp(manaP: Int): Unit = {
    if (0 <= manaP && manaP <= maxManaPoints) {
      manaPoints = manaP
    }
    else {
      throw new IllegalArgumentException("Either the new Mana Points value is negative or over the maximum allowed")
    }
  }

  /**
   * Gets the magic character's current mana points.
   *
   * @return The magic character's current mana points.
   */
  def getMp: Int = manaPoints

  /**
   * Gets the magic character's maximum mana points.
   *
   * @return The magic character's maximum mana points.
   */
  def getMaxMp: Int = maxManaPoints

  /**
   * Applies the magic force potion effect, increasing the magic character's magic damage multiplier.
   */
  def magicForcePotionEffect(): Unit = {
    magicForceMultiplier = 1.5
  }

  /**
   * Resets the magic character's magic damage multiplier to the default value of 1.0.
   */
  def magicForceReset(): Unit = {
    magicForceMultiplier = 1.0
  }

  /**
   * Gets the magic character's current magic damage, based on their equipped weapon and the magic force multiplier.
   *
   * @throws WeaponNotPresent If the magic character does not have a weapon equipped.
   * @return The magic character's current magic damage.
   */
  override def getMagicDamage: Int = Math.round(weaponSlot.getOrElse(throw new WeaponNotPresent(this)).getMagicAttackPoints * magicForceMultiplier)

  protected val compatibleConsumables: List[Potion] = List(new HealingPotion("HealPot"), new StrengthPotion("StrengthPot"), new ManaPotion("ManaPot"), new MagicForcePotion("MagicPot"))

  /**
   * Serializes the magic character's attributes to a JSON object.
   *
   * @return A JSON object representing the magic character's data.
   */
  override def toJson: JsObj = JsObj(
    "id" -> this.id,
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> getName),
      JsObj("name" -> "hp", "value" -> getHp.toString),
      JsObj("name" -> "dp", "value" -> getDp.toString),
      JsObj("name" -> "mp", "value" -> getMp.toString),
      JsObj("name" -> "weight", "value" -> getWeight.toString),
    ),
    "img" -> "mockImage.gif"
  )

  /**
   * Executes an action for the magic character, throwing an `InsufficientHP` exception if the character's health points are 0.
   *
   * @param action The action to be executed.
   * @param target The target of the action.
   * @throws InsufficientHP If the magic character's health points are 0.
   */
  def doAction(action: Action, target: Target): Unit = {
    if (getHp == 0) {
      throw new InsufficientHP(this)
    }
    else {
      action.magicCharacterExecute(this, target)
    }
  }
}
