package model.patterns.factory.potions

import model.items.potions.Potion

/** Factory trait for creating game potions.
 *
 * Provides a method to instantiate a new Potion.
 *
 */
trait PotionFactory {
  /** Creates and returns a new potion.
   *
   * @return A Potion object
   */
  def apply(): Potion
}
