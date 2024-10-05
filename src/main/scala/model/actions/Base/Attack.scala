package model.actions.Base

import model.actions.Action
import spray.json.JsObject
import util.Json.{*, given}

class Attack(name: String) extends Action(name){
  override def id: String = "Attack"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "base→attack"
  )
}
