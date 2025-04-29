package model.items

import api.{GameObject, Target}

/** Trait representing a general item in the game.
 *
 * Extends GameObject and Target, providing basic functionality for all items,
 * such as getting and setting a name.
 */
trait Item extends GameObject with Target {

  /** @return The name of the item. */
  def getName: String

  /** Sets a new name for the item.
   *
   * @param newName The new name to assign.
   */
  def setName(newName: String): Unit
}

