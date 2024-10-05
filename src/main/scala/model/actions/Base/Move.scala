package model.actions.Base

import model.actions.Action
import util.Json.{*, given}

class Move(name: String) extends Action(name) {
  override def id: String = "Move"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "base→move"
  )
}
