package model.items

abstract class AbstractPotion(private var name: String) extends Potion {

  def setName(newName: String): Unit = {
    name = newName
  }

  def getName: String = name
  
}
