package model.items.Weapons

import model.items.AbstractMagicWeapon
import model.units.Character
import util.Json.{*, given}

class Wand(name: String, attackPoints: Int, weight: Int, owner: Character, magicAttackPoints: Int) extends AbstractMagicWeapon(name, attackPoints, weight, owner, magicAttackPoints) {

  override def id: String = "Wand"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
