package model.actions.Usage

import model.actions.AbstractAction
import model.items.Item

// Abstract class for actions involving the use of items
abstract class UsageAction(name: String, private var usableItems: List[Item]) extends AbstractAction(name) {

  // Updates the list of usable items
  def setUsableList(list: List[Item]): Unit = {
    usableItems = list
  }

  // Returns the list of usable items
  def getUsableList: List[Item] = usableItems
  
}
