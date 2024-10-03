package model.items.Potions

import model.items.Potions.Potion

abstract class AbstractPotion(private var name: String) extends Potion {

  def setName(newName: String): Unit = {
    name = newName
  }

  def getName: String = name
  
}
