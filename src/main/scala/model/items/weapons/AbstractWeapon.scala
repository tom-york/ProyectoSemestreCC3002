package model.items.weapons

import model.exceptions.InvalidTarget
import model.units.Units
import model.units.characters.Character
import util.Json.{*, given}

import java.util.UUID

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
  override def getTotalAttack: Int = attackPoints
  
  val id: String = UUID.randomUUID().toString

  // Serialize the weapon to JSON format
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )

  override def moveUnit(unit: Units): Unit = {
    throw new InvalidTarget("Weapon", "Move")
  }

  override def beAttacked(attackDmg: Int): Unit = {
    throw new InvalidTarget("Weapon", "Attack")
  }
}
