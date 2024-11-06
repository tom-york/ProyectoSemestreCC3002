package model.items.weapons

import model.items.Item

/** Trait for magic weapons, extending Item to include magic attack points.
 *
 * Adds additional magic-specific properties, such as setting magic attack points.
 */
trait MagicWeapon extends Item {

  /** Sets the weapon's magic attack points.
   *
   * @param newMAp The new magic attack points.
   */
  def setMagicAttackPoints(newMAp: Int): Unit
}

