package model.items

abstract class Potion(private var name: String) extends Item {

  def setName(newName: String): Unit = {
    name = newName
  }

  def getName: String = name
  
}
