package model.items

import model.units.AbstractCharacter

abstract class AbstractWeapon(private var name: String, private var attackPoints: Int, private var weight: Int, private var owner: AbstractCharacter) extends Weapon {
  
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
