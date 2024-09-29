package model.items.Weapons

import model.items.MagicWeapon
import model.units.AbstractCharacter
import util.Json.{*, given}

class Staff(name: String, attackPoints: Int, weight: Int, owner: AbstractCharacter, magicAttackPoints: Int) extends MagicWeapon(name, attackPoints, weight, owner, magicAttackPoints) {

  override def id: String = "Staff"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
