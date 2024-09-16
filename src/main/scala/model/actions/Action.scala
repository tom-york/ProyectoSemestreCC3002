package model.actions

trait Action {
  def setName(name: String): Unit
  
  def getName: String
}
