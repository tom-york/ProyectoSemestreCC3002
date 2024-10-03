package model.items.Weapons

import model.items.Item
import model.units.Characters.Character

trait Weapon extends Item {

  def setAttackPoints(newAp: Int): Unit

  def setWeight(newWeight: Int): Unit

  def setOwner(newOwner: Character): Unit

  def getAttackPoints: Int

  def getWeight: Int

  def getOwner: Character

}
