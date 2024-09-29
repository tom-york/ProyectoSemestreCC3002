package model.actions

abstract class Action(private var actionName: String) {
  
  def setName(name: String): Unit = {
    actionName = name 
  }

  def getName: String = actionName
}
