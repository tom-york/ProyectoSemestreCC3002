package model.items.weapons

import model.units.characters.Character

/** Abstract class for magic weapons, extending `AbstractWeapon` and adding support for magic attack points.
 *
 * @param name The name of the magic weapon.
 * @param attackPoints The attack points of the magic weapon.
 * @param weight The weight of the magic weapon.
 * @param magicAttackPoints The magic attack points of the weapon.
 *
 * @constructor Initializes a new magic weapon with the specified name, attack points, weight, and magic attack points.
 */
abstract class AbstractMagicWeapon(name: String, attackPoints: Int, weight: Int, private var magicAttackPoints: Int) extends AbstractWeapon(name, attackPoints, weight) with MagicWeapon {

  /** Sets new magic attack points for the weapon.
   *
   * @param newMAp The new magic attack points for the weapon.
   */
  def setMagicAttackPoints(newMAp: Int): Unit = {
    magicAttackPoints = newMAp
  }

  /** Returns the magic attack points of the weapon.
   *
   * @return The magic attack points of the weapon.
   */
  override def getMagicAttackPoints: Int = magicAttackPoints
}
