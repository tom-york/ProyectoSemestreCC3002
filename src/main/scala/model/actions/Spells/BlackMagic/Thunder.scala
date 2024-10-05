package model.actions.Spells.BlackMagic

import model.actions.Spells.Spell
import util.Json.{*, given}

class Thunder(name: String) extends Spell(name) {
  override def id: String = "Thunder"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "spell→blackMagic→thunder"
  )
}
