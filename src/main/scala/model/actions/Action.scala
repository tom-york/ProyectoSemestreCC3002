package model.actions

import api.GameObject

abstract class Action(private var actionName: String) extends GameObject{
  
  def setName(name: String): Unit = {
    actionName = name 
  }

  def getName: String = actionName
}
