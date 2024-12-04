package model.patterns.factory.character

import model.panels.Panel
import model.units.characters.Character

/** Factory trait for creating game characters.
 *
 * Provides a method to instantiate a Character on a specific game panel.
 *
 */
trait CharacterFactory {
  /** Creates a new character and places it on the specified panel.
   *
   * @param panel The game panel where the character will be initialized
   * @return A new Character instance
   */
  def apply(panel: Panel): Character
}
