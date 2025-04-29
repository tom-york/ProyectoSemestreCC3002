package model.actions.usage

import api.Target
import model.actions.AbstractAction
import model.exceptions.InvalidSourceAction
import model.items.Item
import model.units.Enemy

/** Abstract class representing actions that involve using items.
 *
 * Defines behavior for actions that utilize a list of usable items, such as potions or weapons.
 *
 * @param name The name of the action.
 * @param usableItems The list of items that can be used by this action.
 */
abstract class UsageAction(name: String, private var usableItems: List[Item]) extends AbstractAction(name) {

  /** Attempts to execute the action by an enemy, which is invalid for this action type.
   *
   * @param enemy The enemy attempting the action.
   * @param tgt The target of the action.
   * @throws InvalidSourceAction if an enemy attempts to use an item.
   */
  override def enemyExecute(enemy: Enemy, tgt: Target): Unit = {
    throw new InvalidSourceAction(enemy.getName, this.getName)
  }

  /** Updates the list of items usable by this action.
   *
   * @param list The new list of usable items.
   */
  def setUsableList(list: List[Item]): Unit = {
    usableItems = list
  }

  /** @return The current list of items usable by this action. */
  def getUsableList: List[Item] = usableItems
}