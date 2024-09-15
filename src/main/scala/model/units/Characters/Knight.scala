package model.units.Characters

import model.units.AbstractCharacter
import util.Json.{*, given}

class Knight extends AbstractCharacter {

  override def id: String = "Knight"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> getName),
      JsObj("name" -> "hp", "value" -> getHp),
      JsObj("name" -> "dp", "value" -> getDp),
      JsObj("name" -> "weight", "value" -> getWeight),
    )
  )
}
