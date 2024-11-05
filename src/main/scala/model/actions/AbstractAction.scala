package model.actions

import api.GameObject

// Abstract class implementing Action, defines basic action behavior
abstract class AbstractAction(private var actionName: String) extends Action with GameObject{

  // Sets the action's name
  def setName(name: String): Unit = {
    actionName = name 
  }

  // Returns the action's name
  def getName: String = actionName
  
  def getId: String = this.id
  
}
