package model.units

import api.Target
import model.actions.Action
import model.actions.base.{Attack, Move}
import model.panels.IPanel
import util.Json.{*, given}

// Class representing an enemy unit, extending AbstractUnit and adding attack points
class Enemy(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, private var attackPoints: Int) extends AbstractUnit(name, healthPoints, defensePoints, weight, panel) {

  // Setter and getter for the unit's attack points
  def setAtk(sAtk: Int): Unit = {
    attackPoints = sAtk
  }

  def getAtk: Int = attackPoints

  override def getTotalDamage: Int = attackPoints
  
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

  def doAction(action: Action, target: Target): Unit = {
    action.enemyExecute(this, target)
  }

  override val actions: List[Action] = List(new Attack("enemyAttack"), new Move("enemyMove"))
}
