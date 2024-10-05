package model.actions.Spells.WhiteMagic

import model.actions.Spells.Spell
import util.Json.{*, given}

class Purify(name: String) extends Spell(name) {
  override def id: String = "Purify"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "action" -> "spell→whiteMagic→purify"
  )
}
