package model.items.Weapons

import model.units.Characters.Character

abstract class AbstractWeapon(private var name: String, private var attackPoints: Int, private var weight: Int, private var owner: Character) extends Weapon {
  
  def setName(newName: String): Unit = {
    name = newName
  }

  def setAttackPoints(newAp: Int): Unit = {
    attackPoints = newAp
  }
  
  def setWeight(newWeight: Int): Unit = {
    weight = newWeight
  }
  
  def setOwner(newOwner: Character): Unit = {
    owner = newOwner
  }

  def getName: String = name

  def getAttackPoints: Int = attackPoints

  def getWeight: Int = weight

  def getOwner: Character = owner
  
}
