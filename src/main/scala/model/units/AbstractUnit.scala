package model.units

import api.{Source, Target}
import model.actions.Action
import model.exceptions.{DefeatedTarget, InvalidActionTarget, NoIdFound}
import model.panels.IPanel
import model.patterns.observer.Subject
import model.units.characters.{Character, MagicCharacter}

import java.util.UUID

/**
 * Abstract class implementing the `Units` trait with basic fields and methods.
 *
 * This class provides the foundation for all unit entities in the game, including common properties and
 * functionality such as health points, defense points, weight, panel management, and basic actions.
 *
 * @param name The name of the unit.
 * @param maxHealthPoints The maximum health points of the unit.
 * @param defensePoints The defense points of the unit.
 * @param weight The weight of the unit.
 * @param panel The panel associated with the unit.
 */
abstract class AbstractUnit(override val name: String, private val maxHealthPoints: Int, private var defensePoints: Int, private var weight: Int, private var panel: IPanel) extends Units {

  private var healthPoints: Int = maxHealthPoints

  panel.addUnit(this)

  /** Sets the unit's health points with validation.
   *
   * Updates health points if the new value is within valid range (0 to maxHealthPoints).
   * Notifies observers if health points reach zero, indicating unit defeat.
   *
   * @param sHp The new health points value
   * @throws IllegalArgumentException If health points are negative or exceed maximum
   */
  override def setHp(sHp: Int): Unit = {
    if (0 <= sHp && sHp <= maxHealthPoints) {
      healthPoints = sHp
    }
    else {
      throw new IllegalArgumentException("Either the new HP is negative or over the maximum HP allowed")
    }
    if (healthPoints == 0) {
      notifyObservers(true)
    }
  }

  /**
   * Sets the unit's defense points.
   *
   * @param sDp The new defense points value for the unit.
   */
  override def setDp(sDp: Int): Unit = {
    defensePoints = sDp
  }

  /**
   * Sets the unit's weight.
   *
   * @param sWeight The new weight value for the unit.
   */
  override def setWeight(sWeight: Int): Unit = {
    weight = sWeight
  }

  /**
   * Moves the unit to a new panel.
   *
   * @param newPanel The new panel for the unit.
   */
  override def movePanel(newPanel: IPanel): Unit = {
    panel.removeUnit(this)
    panel = newPanel
    panel.addUnit(this)
  }

  /**
   * Gets the unit's name.
   *
   * @return The name of the unit.
   */
  override def getName: String = name

  /**
   * Gets the unit's current health points.
   *
   * @return The unit's current health points.
   */
  override def getHp: Int = healthPoints

  /**
   * Gets the unit's defense points.
   *
   * @return The unit's defense points.
   */
  override def getDp: Int = defensePoints

  /**
   * Gets the unit's weight.
   *
   * @return The unit's weight.
   */
  override def getWeight: Int = weight

  /**
   * Gets the panel associated with the unit.
   *
   * @return The panel associated with the unit.
   */
  override def getPanel: IPanel = panel

  /**
   * Gets the unit's maximum health points.
   *
   * @return The unit's maximum health points.
   */
  override def getMaxHp: Int = maxHealthPoints

  /**
   * Gets the unit's unique identifier.
   *
   * @return The unit's unique identifier.
   */
  override def getId: String = this.id

  val id: String = UUID.randomUUID().toString

  /**
   * Finds an action by its ID.
   *
   * @param actionId The ID of the action to find.
   * @return The action with the specified ID.
   * @throws NoIdFound If the action with the specified ID is not found.
   */
  override def findActionById(actionId: String): Action = {
    val actionList: List[Action] = this.actions
    actionList.find(_.getId == actionId).getOrElse(
      throw new NoIdFound(actionId)
    )
  }

  /**
   * Applies attack damage to the unit, reducing its health points.
   *
   * @param attackDmg The amount of attack damage.
   */
  override def beAttacked(attackDmg: Int): Unit = {
    val netAttack: Int = attackDmg - defensePoints
    if (netAttack >= 0) {
      if (netAttack > healthPoints) {
        setHp(0)
      }
      else {
        setHp(healthPoints - netAttack)
      }
    }
  }

  /**
   * Applies the "Thunder" action to the unit, dealing magic damage.
   *
   * @param magicCharacter The magic character performing the "Thunder" action.
   * @throws DefeatedTarget If the unit's health points are already 0.
   */
  override def useThunder(magicCharacter: MagicCharacter): Unit = {
    if (getHp == 0) {
      throw new DefeatedTarget(this)
    }
    else {
      val damageAmount: Int = magicCharacter.getMagicDamage
      beAttacked(damageAmount)
    }
  }

  /**
   * Throws an `InvalidActionTarget` exception, as the "Move" action is not valid for a generic unit.
   *
   * @param unit The unit to be moved.
   * @throws InvalidActionTarget As the action doesn't match the correct target
   */
  override def moveUnit(unit: Units): Unit = {
    throw new InvalidActionTarget("Unit", "Move")
  }

  /**
   * Throws an `InvalidActionTarget` exception, as the "Equip" action is not valid for a generic unit.
   *
   * @param character The character trying to equip a weapon.
   * @throws InvalidActionTarget As the action doesn't match the correct target
   */
  override def equipWeapon(character: characters.Character): Unit = {
    throw new InvalidActionTarget("Unit", "Equip")
  }

  /**
   * Throws an `InvalidActionTarget` exception, as the "Meteorite" action is not valid for a generic unit.
   *
   * @param magicCharacter The magic character trying to use the "Meteorite" action.
   * @throws InvalidActionTarget As the action doesn't match the correct target
   */
  override def useMeteorite(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Unit", "Meteorite")
  }

  /**
   * Throws an `InvalidActionTarget` exception, as the "Consume" action is not valid for a generic unit.
   *
   * @param magicCharacter The magic character trying to consume an item.
   * @throws InvalidActionTarget As the action doesn't match the correct target
   */
  override def magicCharacterConsume(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Unit", "Consume")
  }

  /**
   * Throws an `InvalidActionTarget` exception, as the "Consume" action is not valid for a generic unit.
   *
   * @param character The character trying to consume an item.
   * @throws InvalidActionTarget As the action doesn't match the correct target
   */
  override def characterConsume(character: Character): Unit = {
    throw new InvalidActionTarget("Unit", "Consume")
  }
}