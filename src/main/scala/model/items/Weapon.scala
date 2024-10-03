package model.items

import model.units.AbstractCharacter

trait Weapon extends Item {

  def setAttackPoints(newAp: Int): Unit

  def setWeight(newWeight: Int): Unit

  def setOwner(newOwner: AbstractCharacter): Unit

  def getAttackPoints: Int

  def getWeight: Int

  def getOwner: AbstractCharacter

}
