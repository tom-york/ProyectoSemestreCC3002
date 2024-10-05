package model.units

import util.Json.{*, given}

class Enemy(name: String, healthPoints: Int, defensePoints: Int, weight: Int, private var attackPoints: Int) extends AbstractUnit(name, healthPoints, defensePoints, weight) {

  def setAtk(sAtk: Int): Unit = {
    attackPoints = sAtk
  }

  def getAtk: Int = attackPoints

  override def id: String = "Enemy"

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

  def calculateActionBarMax: Double = weight.toDouble
}
