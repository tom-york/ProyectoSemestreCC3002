package model.patterns.factory.weapon

import model.items.weapons.Weapon

/** Factory trait for creating game weapons.
 *
 * Provides a method to instantiate a new Weapon.
 *
 */
trait WeaponFactory {
  /** Creates and returns a new weapon.
   *
   * @return A Weapon object
   */
  def apply(): Weapon 
}
