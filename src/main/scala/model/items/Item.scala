package model.items

trait Item {
  
  def getName: String

  def setName(newName: String): Unit
  
}
