package model.items.Weapons

import model.items.AbstractWeapon
import model.units.Character
import util.Json.{*, given}

class Sword(name: String, attackPoints: Int, weight: Int, owner: Character) extends AbstractWeapon(name, attackPoints, weight, owner) {

  override def id: String = "Sword"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
