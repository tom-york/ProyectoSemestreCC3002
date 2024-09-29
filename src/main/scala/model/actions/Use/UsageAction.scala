package model.actions.Use

import model.actions.Action
import model.items.Item

abstract class UsageAction(name: String, private var usableItems: List[Item]) extends Action(name) {

  def setUsableList(list: List[Item]): Unit = {
    usableItems = list
  }

  def getUsableList: List[Item] = usableItems
  
}
