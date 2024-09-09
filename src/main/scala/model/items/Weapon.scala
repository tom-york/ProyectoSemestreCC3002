package model.items

import model.units.AbstractCharacter

abstract class Weapon extends Item {

  private var name: String = _

  private var attackPoints: Int = _

  private var weight: Int = _

  private var owner: AbstractCharacter = _
  
  def setName(newName: String): Unit = {
    name = newName
  }

  def setAttackPoints(newAp: Int): Unit = {
    attackPoints = newAp
  }
  
  def setWeight(newWeight: Int): Unit = {
    weight = newWeight
  }
  
  def setOwner(newOwner: AbstractCharacter): Unit = {
    owner = newOwner
  }

  def getName: String = name

  def getAttackPoints: Int = attackPoints

  def getWeight: Int = weight

  def getOwner: AbstractCharacter = owner
  
}
