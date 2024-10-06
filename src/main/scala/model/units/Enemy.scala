package model.units

import util.Json.{*, given}

// Class representing an enemy unit, extending AbstractUnit and adding attack points
class Enemy(name: String, healthPoints: Int, defensePoints: Int, weight: Int, private var attackPoints: Int) extends AbstractUnit(name, healthPoints, defensePoints, weight) {

  // Setter and getter for the unit's attack points
  def setAtk(sAtk: Int): Unit = {
    attackPoints = sAtk
  }

  def getAtk: Int = attackPoints

  // Unique identifier for enemy units
  override def id: String = "Enemy"

  // Serialize the enemy's attributes to JSON
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> getName),
      JsObj("name" -> "hp", "value" -> getHp.toString),
      JsObj("name" -> "atk", "value" -> getAtk.toString),
      JsObj("name" -> "dp", "value" -> getDp.toString),
      JsObj("name" -> "weight", "value" -> getWeight.toString),
    )
  )

  // Calculates the maximum action bar value based on weight
  def calculateActionBarMax: Double = weight.toDouble
}
