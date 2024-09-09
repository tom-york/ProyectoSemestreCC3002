package model.items

abstract class Potion extends Item {

  private var name: String = _

  def setName(newName: String): Unit = {
    name = newName
  }

  def getName: String = name
  
}
