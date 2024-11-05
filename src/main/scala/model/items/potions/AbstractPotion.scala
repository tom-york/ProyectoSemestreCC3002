package model.items.potions

import model.exceptions.InvalidActionTarget
import model.units.{Units, characters}
import model.units.characters.MagicCharacter
import util.Json.{*, given}

import java.util.UUID

// Abstract class implementing the Potion trait, defining a basic potion
abstract class AbstractPotion(private var name: String) extends Potion {

  // Setter and getter for the potion's name
  def setName(newName: String): Unit = {
    name = newName
  }

  def getName: String = name

  val id: String = UUID.randomUUID().toString
  
  // Serialize the potion to JSON format
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )

  override def moveUnit(unit: Units): Unit = {
    throw new InvalidActionTarget("Potion", "Move")
  }

  override def beAttacked(attackDmg: Int): Unit = {
    throw new InvalidActionTarget("Potion", "Attack")
  }

  override def equipWeapon(character: characters.Character): Unit = {
    throw new InvalidActionTarget("Potion", "Equip")
  }

  override def healCharacter(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Potion", "Heal")
  }

  override def purifyEnemy(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Potion", "Purify")
  }

  override def useMeteorite(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Potion", "Meteorite")
  }

  override def useThunder(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Potion", "Thunder")
  }
}
