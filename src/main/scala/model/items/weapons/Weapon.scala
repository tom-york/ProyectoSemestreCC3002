package model.items.weapons

import model.items.Item
import model.units.characters.Character

/** Trait for weapons, extending Item with weapon-specific attributes and behavior.
 *
 * Adds attributes such as attack points, weight, and owner, 
 * and defines methods to get and set these values.
 */
trait Weapon extends Item {

  /** Sets the weapon's attack points.
   *
   * @param newAp The new attack points.
   */
  def setAttackPoints(newAp: Int): Unit

  /** Sets the weapon's weight.
   *
   * @param newWeight The new weight of the weapon.
   */
  def setWeight(newWeight: Int): Unit

  /** Assigns an owner to the weapon.
   *
   * @param newOwner The character who will own the weapon.
   */
  def setOwner(newOwner: Character): Unit

  /** @return The attack points of the weapon. */
  def getAttackPoints: Int

  /** @return The weight of the weapon. */
  def getWeight: Int

  /** @return The character that owns the weapon, if any. */
  def getOwner: Option[Character]

  /** @return The magic attack points of the weapon, if applicable. */
  def getMagicAttackPoints: Int
}
