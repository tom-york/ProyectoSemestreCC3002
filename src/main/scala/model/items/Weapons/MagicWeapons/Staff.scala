package model.items.Weapons.MagicWeapons

import model.items.Weapons.AbstractMagicWeapon
import model.units.Characters.Character
import util.Json.{*, given}

class Staff(name: String, attackPoints: Int, weight: Int, owner: Character, magicAttackPoints: Int) extends AbstractMagicWeapon(name, attackPoints, weight, owner, magicAttackPoints) {

  override def id: String = "Staff"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
