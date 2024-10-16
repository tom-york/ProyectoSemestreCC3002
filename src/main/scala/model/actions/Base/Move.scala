package model.actions.Base

import model.actions.AbstractAction
import util.Json.{*, given}

class Move(name: String) extends AbstractAction(name) {

  override def id: String = "2" // Identifier for this action

  // Converts the action and its details to a JSON object
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "base→move"
  )
}
