package model.items

import model.units.Character

trait Weapon extends Item {

  def setAttackPoints(newAp: Int): Unit

  def setWeight(newWeight: Int): Unit

  def setOwner(newOwner: Character): Unit

  def getAttackPoints: Int

  def getWeight: Int

  def getOwner: Character

}
