package model.items.Weapons

import model.items.Item
import model.units.Characters.Character

// Trait for weapons, extending Item with additional weapon-specific properties
trait Weapon extends Item {

  // Setters for weapon attributes: attack points, weight, and owner
  def setAttackPoints(newAp: Int): Unit
  def setWeight(newWeight: Int): Unit
  def setOwner(newOwner: Character): Unit

  // Getters for weapon attributes
  def getAttackPoints: Int
  def getWeight: Int
  def getOwner: Character
}
