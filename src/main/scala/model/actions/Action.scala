package model.actions

import api.GameObject

// Abstract class implementing IAction, defines basic action behavior
abstract class Action(private var actionName: String) extends GameObject{

  // Sets the action's name
  def setName(name: String): Unit = {
    actionName = name 
  }

  // Returns the action's name
  def getName: String = actionName
}
