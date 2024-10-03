package model.items.Weapons.NormalWeapons

import model.items.Weapons.AbstractWeapon
import model.units.Characters.Character
import util.Json.{*, given}

class Dagger(name: String, attackPoints: Int, weight: Int, owner: Character) extends AbstractWeapon(name, attackPoints, weight, owner) {

  override def id: String = "Dagger"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
