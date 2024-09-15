package model.units.Characters

import model.units.AbstractMagicCharacter
import util.Json.{*, given}

class WhiteWizard extends AbstractMagicCharacter{

  override def id: String = "WhiteWizard"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> getName),
      JsObj("name" -> "hp", "value" -> getHp),
      JsObj("name" -> "dp", "value" -> getDp),
      JsObj("name" -> "dp", "value" -> getMp),
      JsObj("name" -> "weight", "value" -> getWeight),
    )
  )
}
