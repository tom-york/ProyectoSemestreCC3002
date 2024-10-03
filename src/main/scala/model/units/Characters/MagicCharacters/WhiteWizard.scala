package model.units.Characters.MagicCharacters

import model.items.Item
import model.items.Weapons.Weapon
import model.units.Characters.AbstractMagicCharacter
import util.Json.{*, given}

class WhiteWizard(name: String, healthPoints: Int, defensePoints: Int, weight: Int, weaponSlot: Option[Weapon], itemInventory: List[Item], manaPoints: Int) extends AbstractMagicCharacter(name, healthPoints, defensePoints, weight, weaponSlot, itemInventory, manaPoints) {

  override def id: String = "WhiteWizard"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> getName),
      JsObj("name" -> "hp", "value" -> getHp),
      JsObj("name" -> "dp", "value" -> getDp),
      JsObj("name" -> "dp", "value" -> getMp),
      JsObj("name" -> "weight", "value" -> getWeight),
    )
  )
}
