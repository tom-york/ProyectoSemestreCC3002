package model.units.characters

import api.Target
import model.actions.Action
import model.exceptions.WeaponNotPresent
import model.items.Item
import model.items.weapons.Weapon
import model.items.potions.Potion
import model.items.potions.magic.*
import model.items.potions.normal.*
import model.panels.IPanel
import util.Json.{*, given}

// Abstract class for magic characters, extending AbstractCharacter and adding mana points
abstract class AbstractMagicCharacter(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, weaponSlot: Option[Weapon], itemInventory: List[Item], private var maxManaPoints: Int) extends AbstractCharacter(name, healthPoints, defensePoints, weight, panel, weaponSlot, itemInventory) with MagicCharacter {

  private var manaPoints: Int = maxManaPoints

  private var magicForceMultiplier: Float = 1.0
  
  // Setter and getter for the character's mana points
  override def setMp(manaP: Int): Unit = {
    if (0 <= manaP && manaP <= maxManaPoints) {
      manaPoints = manaP
    }
    else {
      throw new IllegalArgumentException("Either the new Mana Points value is negative or over the maximum allowed")
    }
  }
  
  def getMp: Int = manaPoints

  def getMaxMp: Int = maxManaPoints
  
  def magicForcePotionEffect(): Unit = {
    magicForceMultiplier = 1.5
  }
  
  def magicForceReset(): Unit = {
    magicForceMultiplier = 1.0
  }
  
  override def getMagicDamage: Int = Math.round(weaponSlot.getOrElse(throw new WeaponNotPresent(this)).getMagicAttackPoints * magicForceMultiplier)

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
