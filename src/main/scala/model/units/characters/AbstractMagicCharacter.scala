package model.units.characters

import api.Target
import model.actions.Action
import model.items.Item
import model.items.weapons.Weapon
import model.items.potions.Potion
import model.items.potions.magic.*
import model.items.potions.normal.*
import model.panels.IPanel
import util.Json.{*, given}

// Abstract class for magic characters, extending AbstractCharacter and adding mana points
abstract class AbstractMagicCharacter(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, weaponSlot: Option[Weapon], itemInventory: List[Item], private var manaPoints: Int) extends AbstractCharacter(name, healthPoints, defensePoints, weight, panel, weaponSlot, itemInventory) with MagicCharacter {

  // Setter and getter for the character's mana points
  def setMp(manaP: Int): Unit = {
    manaPoints = manaP
  }

  def getMp: Int = manaPoints

  protected val compatibleConsumables: List[Potion] = List(new HealingPotion("HealPot"), new StrengthPotion("StrengthPot"), new ManaPotion("ManaPot"), new MagicForcePotion("MagicPot"))

  // Serialize the magic character's attributes to JSON
  override def toJson: JsObj = JsObj(
    "id" -> this.id,
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> getName),
      JsObj("name" -> "hp", "value" -> getHp.toString),
      JsObj("name" -> "dp", "value" -> getDp.toString),
      JsObj("name" -> "mp", "value" -> getMp.toString),
      JsObj("name" -> "weight", "value" -> getWeight.toString),
    ),
    "img" -> "mockImage.gif"
  )

  def doAction(action: Action, target: Target): Unit = {
    action.magicCharacterExecute(this, target)
  }
}
