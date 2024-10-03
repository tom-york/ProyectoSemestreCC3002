package model.items.Weapons

import model.items.AbstractWeapon
import model.units.Character
import util.Json.{*, given}

class Bow(name: String, attackPoints: Int, weight: Int, owner: Character) extends AbstractWeapon(name, attackPoints, weight, owner) {

  override def id: String = "Bow"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
