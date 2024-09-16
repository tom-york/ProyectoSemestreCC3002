package model.actions

trait IAction {
  def setName(name: String): Unit
  
  def getName: String
}
