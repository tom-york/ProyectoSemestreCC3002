package model.items.potions

import model.exceptions.InvalidActionTarget
import model.units.{Units, characters}
import model.units.characters.MagicCharacter
import util.Json.{*, given}

import java.util.UUID

/**
 * Abstract class implementing the `Potion` trait, defining a basic potion.
 *
 * @param name The name of the potion.
 *
 * @constructor Initializes the potion with a name and generates a unique ID.
 */
abstract class AbstractPotion(private var name: String) extends Potion {

  /**
   * Sets the name of the potion.
   *
   * @param newName The new name for the potion.
   */
  def setName(newName: String): Unit = {
    name = newName
  }

  /**
   * Gets the name of the potion.
   *
   * @return The name of the potion.
   */
  def getName: String = name

  /** Unique ID for the potion instance. */
  val id: String = UUID.randomUUID().toString

  /**
   * Serializes the potion to JSON format.
   *
   * @return The JSON representation of the potion.
   */
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )

  /**
   * Throws an error for invalid action on potions.
   * This action is not supported for potions.
   *
   * @param unit The unit to move (ignored, as potions cannot move).
   *
   * @throws InvalidActionTarget If invoked on a potion.
   */
  override def moveUnit(unit: Units): Unit = {
    throw new InvalidActionTarget("Potion", "Move")
  }

  /**
   * Throws an error for invalid action on potions.
   * This action is not supported for potions.
   *
   * @param attackDmg The attack damage (ignored, as potions cannot be attacked).
   *
   * @throws InvalidActionTarget If invoked on a potion.
   */
  override def beAttacked(attackDmg: Int): Unit = {
    throw new InvalidActionTarget("Potion", "Attack")
  }

  /**
   * Throws an error for invalid action on potions.
   * This action is not supported for potions.
   *
   * @param character The character to equip the potion to (ignored, as potions cannot be equipped).
   *
   * @throws InvalidActionTarget If invoked on a potion.
   */
  override def equipWeapon(character: characters.Character): Unit = {
    throw new InvalidActionTarget("Potion", "Equip")
  }

  /**
   * Throws an error for invalid action on potions.
   * This action is not supported for potions.
   *
   * @param magicCharacter The magic character to heal (ignored, as potions cannot heal).
   *
   * @throws InvalidActionTarget If invoked on a potion.
   */
  override def healCharacter(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Potion", "Heal")
  }

  /**
   * Throws an error for invalid action on potions.
   * This action is not supported for potions.
   *
   * @param magicCharacter The magic character to purify (ignored, as potions cannot purify).
   *
   * @throws InvalidActionTarget If invoked on a potion.
   */
  override def purifyEnemy(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Potion", "Purify")
  }

  /**
   * Throws an error for invalid action on potions.
   * This action is not supported for potions.
   *
   * @param magicCharacter The magic character using the meteorite (ignored, as potions cannot use meteorites).
   *
   * @throws InvalidActionTarget If invoked on a potion.
   */
  override def useMeteorite(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Potion", "Meteorite")
  }

  /**
   * Throws an error for invalid action on potions.
   * This action is not supported for potions.
   *
   * @param magicCharacter The magic character using thunder (ignored, as potions cannot use thunder).
   *
   * @throws InvalidActionTarget If invoked on a potion.
   */
  override def useThunder(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Potion", "Thunder")
  }
}
