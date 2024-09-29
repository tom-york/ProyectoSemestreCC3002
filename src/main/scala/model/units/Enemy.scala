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
      JsObj("name" -> "hp", "value" -> getHp),
      JsObj("name" -> "atk", "value" -> getAtk),
      JsObj("name" -> "dp", "value" -> getDp),
      JsObj("name" -> "weight", "value" -> getWeight),
    )
  )
}
