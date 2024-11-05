package model.actions.usage

import api.Target
import model.actions.AbstractAction
import model.exceptions.InvalidSourceAction
import model.items.Item
import model.units.Enemy

// Abstract class for actions involving the use of items
abstract class UsageAction(name: String, private var usableItems: List[Item]) extends AbstractAction(name) {

  override def enemyExecute(enemy: Enemy, tgt: Target): Unit = {
    throw new InvalidSourceAction(enemy.getName, this.getName)
  }
  
  // Updates the list of usable items
  def setUsableList(list: List[Item]): Unit = {
    usableItems = list
  }

  // Returns the list of usable items
  def getUsableList: List[Item] = usableItems
  
}