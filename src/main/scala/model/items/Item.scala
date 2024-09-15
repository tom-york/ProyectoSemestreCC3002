package model.items

import api.GameObject

trait Item extends GameObject{
  
  def getName: String

  def setName(newName: String): Unit
  
}
