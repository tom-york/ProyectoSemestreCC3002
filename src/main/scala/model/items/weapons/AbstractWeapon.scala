package model.items.weapons

import model.exceptions.{InvalidActionTarget, MagicWeaponNotPresent}
import model.units.Units
import model.units.characters.{Character, MagicCharacter}
import util.Json.{*, given}

import java.util.UUID

/**
 * Abstract base class for basic weapons, implementing the `Weapon` trait.
 *
 * Provides concrete behavior for a standard weapon, including setting and getting properties
 * such as attack points, weight, and owner. Additionally, defines a unique ID for each weapon.
 *
 * @param name The initial name of the weapon.
 * @param attackPoints The initial attack points of the weapon.
 * @param weight The initial weight of the weapon.
 *
 * @constructor Initializes a new weapon with the specified name, attack points, and weight.
 */
abstract class AbstractWeapon(private var name: String, private var attackPoints: Int, private var weight: Int) extends Weapon {
  
  /** The owner of the weapon, initially set to None. */
  private var owner: Option[Character] = None

  /** Sets a new name for the weapon.
   *
   * @param newName The new name for the weapon.
   */
  def setName(newName: String): Unit = { name = newName }

  /** Sets new attack points for the weapon.
   *
   * @param newAp The new attack points for the weapon.
   */
  def setAttackPoints(newAp: Int): Unit = { attackPoints = newAp }

  /** Sets new weight for the weapon.
   *
   * @param newWeight The new weight for the weapon.
   */
  def setWeight(newWeight: Int): Unit = { weight = newWeight }

  /** Sets the new owner of the weapon. Updates the owner's weapon if they already have one.
   *
   * @param newOwner The new owner of the weapon.
   */
  def setOwner(newOwner: Character): Unit = {
    if (owner.isDefined) owner.get.setWeapon(None)
    owner = Some(newOwner)
    newOwner.setWeapon(Some(this))
  }

  /** Returns the name of the weapon.
   *
   * @return The name of the weapon.
   */
  def getName: String = name

  /** Returns the attack points of the weapon.
   *
   * @return The attack points of the weapon.
   */
  def getAttackPoints: Int = attackPoints

  /** Returns the weight of the weapon.
   *
   * @return The weight of the weapon.
   */
  def getWeight: Int = weight

  /** Returns the owner of the weapon, if defined.
   *
   * @return The owner of the weapon, wrapped in an `Option`.
   */
  def getOwner: Option[Character] = owner

  /** Throws an exception, as magic attack points are not supported for this type of weapon.
   *
   * @throws MagicWeaponNotPresent If invoked on a non-magic weapon.
   */
  override def getMagicAttackPoints: Int = throw new MagicWeaponNotPresent()

  /** Unique identifier for each weapon instance.
   *
   * @return The unique ID for the weapon.
   */
  val id: String = UUID.randomUUID().toString

  /** Serializes the weapon to JSON format.
   *
   * @return The JSON representation of the weapon.
   */
  override def toJson: JsObj = JsObj("id" -> id, "name" -> getName)



  // Default implementations for Target-specific methods, invalid for weapons.



  /** Moves the unit, invalid for weapons.
   *
   * @param unit The unit to move (ignored as weapons cannot move).
   *
   * @throws InvalidActionTarget If invoked on a weapon.
   */
  override def moveUnit(unit: Units): Unit = throw new InvalidActionTarget("Weapon", "Move")

  /** Attacks a unit, invalid for weapons.
   *
   * @param attackDmg The attack damage (ignored as weapons cannot be attacked).
   *
   * @throws InvalidActionTarget If invoked on a weapon.
   */
  override def beAttacked(attackDmg: Int): Unit = throw new InvalidActionTarget("Weapon", "Attack")

  /** Consumes a character, invalid for weapons.
   *
   * @param character The character consuming the weapon (invalid action for weapons).
   *
   * @throws InvalidActionTarget If invoked on a weapon.
   */
  override def characterConsume(character: Character): Unit = throw new InvalidActionTarget("Weapon", "Consume")

  /** Consumes a magic character, invalid for weapons.
   *
   * @param magicCharacter The magic character consuming the weapon (invalid action for weapons).
   *
   * @throws InvalidActionTarget If invoked on a weapon.
   */
  override def magicCharacterConsume(magicCharacter: MagicCharacter): Unit = throw new InvalidActionTarget("Weapon", "Consume")

  /** Heals a magic character, invalid for weapons.
   *
   * @param magicCharacter The magic character being healed (invalid action for weapons).
   *
   * @throws InvalidActionTarget If invoked on a weapon.
   */
  override def healCharacter(magicCharacter: MagicCharacter): Unit = throw new InvalidActionTarget("Weapon", "Heal")

  /** Purifies an enemy, invalid for weapons.
   *
   * @param magicCharacter The magic character performing the purification (invalid action for weapons).
   *
   * @throws InvalidActionTarget If invoked on a weapon.
   */
  override def purifyEnemy(magicCharacter: MagicCharacter): Unit = throw new InvalidActionTarget("Weapon", "Purify")

  /** Uses a meteorite, invalid for weapons.
   *
   * @param magicCharacter The magic character using the meteorite (invalid action for weapons).
   *
   * @throws InvalidActionTarget If invoked on a weapon.
   */
  override def useMeteorite(magicCharacter: MagicCharacter): Unit = throw new InvalidActionTarget("Weapon", "Meteorite")

  /** Uses thunder, invalid for weapons.
   *
   * @param magicCharacter The magic character using thunder (invalid action for weapons).
   *
   * @throws InvalidActionTarget If invoked on a weapon.
   */
  override def useThunder(magicCharacter: MagicCharacter): Unit = throw new InvalidActionTarget("Weapon", "Thunder")
}

