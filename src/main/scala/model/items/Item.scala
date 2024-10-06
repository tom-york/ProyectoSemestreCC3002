package model.items

import api.GameObject

// Trait for any item in the game, extending GameObject
trait Item extends GameObject {

  // Getter and setter for the item's name
  def getName: String
  def setName(newName: String): Unit
}

