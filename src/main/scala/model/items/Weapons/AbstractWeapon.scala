package model.items.Weapons

import model.units.Characters.Character
import util.Json.{*, given}

// Abstract class implementing the Weapon trait, defining a basic weapon
abstract class AbstractWeapon(private var name: String, private var attackPoints: Int, private var weight: Int, private var owner: Character) extends Weapon {

  // Setters for the weapon's properties
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

  // Getters for the weapon's properties
  def getName: String = name
  def getAttackPoints: Int = attackPoints
  def getWeight: Int = weight
  def getOwner: Character = owner

  // Serialize the weapon to JSON format
  override def toJson: JsObj = JsObj(
    "id" -> this.id,
    "name" -> getName
  )
}
