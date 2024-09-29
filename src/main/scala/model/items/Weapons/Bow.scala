package model.items.Weapons

import model.items.Weapon
import model.units.AbstractCharacter
import util.Json.{*, given}

class Bow(name: String, attackPoints: Int, weight: Int, owner: AbstractCharacter) extends Weapon(name, attackPoints, weight, owner) {

  override def id: String = "Bow"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
