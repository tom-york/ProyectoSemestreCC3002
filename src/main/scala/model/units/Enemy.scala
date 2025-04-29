package model.units

import api.Target
import model.actions.Action
import model.actions.base.{Attack, Move}
import model.exceptions.{DefeatedTarget, InsufficientHP, InvalidActionTarget, NoIdFound}
import model.panels.IPanel
import model.units.characters.MagicCharacter
import util.Json.{*, given}

/**
 * Class representing an enemy unit, extending `AbstractUnit` and adding attack points.
 *
 * This class defines the basic properties and behavior for enemy entities in the game, including
 * managing their attack points and implementing actions such as attacking and moving.
 *
 * @param name The name of the enemy.
 * @param healthPoints The maximum health points of the enemy.
 * @param defensePoints The defense points of the enemy.
 * @param weight The weight of the enemy.
 * @param panel The panel associated with the enemy.
 * @param attackPoints The attack points of the enemy.
 */
class Enemy(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, private var attackPoints: Int) extends AbstractUnit(name, healthPoints, defensePoints, weight, panel) {

  /**
   * Sets the enemy's attack points.
   *
   * @param sAtk The new attack points value for the enemy.
   */
  def setAtk(sAtk: Int): Unit = {
    attackPoints = sAtk
  }

  /**
   * Gets the enemy's attack points.
   *
   * @return The enemy's attack points.
   */
  def getAtk: Int = attackPoints

  /**
   * Gets the enemy's total damage, which is their attack points.
   *
   * @return The enemy's total damage.
   */
  override def getTotalDamage: Int = attackPoints

  /**
   * Serializes the enemy's attributes to a JSON object.
   *
   * @return A JSON object representing the enemy's data.
   */
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> getName),
      JsObj("name" -> "hp", "value" -> getHp.toString),
      JsObj("name" -> "atk", "value" -> getAtk.toString),
      JsObj("name" -> "dp", "value" -> getDp.toString),
      JsObj("name" -> "weight", "value" -> getWeight.toString),
    )
  )

  /**
   * Calculates the enemy's maximum action bar value, based on their weight.
   *
   * @return The enemy's maximum action bar value.
   */
  def calculateActionBarMax: Double = weight.toDouble

  /**
   * Executes an action for the enemy, throwing an `InsufficientHP` exception if the enemy's health points are 0.
   *
   * @param action The action to be executed.
   * @param target The target of the action.
   * @throws InsufficientHP If the enemy's health points are 0.
   */
  def doAction(action: Action, target: Target): Unit = {
    if (getHp == 0) {
      throw new InsufficientHP(this)
    }
    else {
      action.enemyExecute(this, target)
    }
  }

  /**
   * Applies the "Purify" action to the enemy, dealing damage based on a percentage of the enemy's maximum health points
   * and a fraction of the magic character's magic damage.
   *
   * @param magicCharacter The magic character performing the "Purify" action.
   * @throws DefeatedTarget If the enemy's health points are already 0.
   */
  override def purifyEnemy(magicCharacter: MagicCharacter): Unit = {
    if (getHp == 0) {
      throw new DefeatedTarget(this)
    }
    else {
      val damagePercentage: Float = 0.15
      val magicDamageFraction: Float = magicCharacter.getMagicDamage / 2
      val damageAmount: Int = Math.round((getMaxHp * damagePercentage) + magicDamageFraction)
      beAttacked(damageAmount)
    }
  }

  override val actions: List[Action] = List(new Attack("enemyAttack"), new Move("enemyMove"))

  /**
   * Throws an `InvalidActionTarget` exception, as the "Heal" action is not valid for an enemy.
   *
   * @param magicCharacter The magic character trying to heal the enemy.
   * @throws InvalidActionTarget
   */
  override def healCharacter(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Enemy", "Heal")
  }
}
