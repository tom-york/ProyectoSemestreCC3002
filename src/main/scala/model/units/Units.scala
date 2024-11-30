package model.units

import api.{GameObject, Source, Target}
import model.panels.IPanel
import model.patterns.observer.ISubject
import model.scheduler.TaskScheduler

/**
 * Trait that defines common behavior for units in the game.
 * Extends GameObject, Source, and Target, allowing units to interact with game elements.
 */
trait Units extends GameObject with Source with Target with ISubject[Boolean] {

  /**
   * Sets the health points of the unit.
   * @param sHp the health points to set
   */
  def setHp(sHp: Int): Unit

  /**
   * Sets the defense points of the unit.
   * @param sDp the defense points to set
   */
  def setDp(sDp: Int): Unit

  /**
   * Sets the weight of the unit.
   * @param sWeight the weight to set
   */
  def setWeight(sWeight: Int): Unit

  /**
   * Gets the name of the unit.
   * @return the name of the unit
   */
  def getName: String

  /**
   * Gets the current health points of the unit.
   * @return the current health points
   */
  def getHp: Int

  /**
   * Gets the defense points of the unit.
   * @return the defense points
   */
  def getDp: Int

  /**
   * Gets the weight of the unit.
   * @return the weight
   */
  def getWeight: Int

  /**
   * Gets the panel in which the unit is currently located.
   * @return the current panel
   */
  def getPanel: IPanel

  /**
   * Gets the maximum health points of the unit.
   * @return the maximum health points
   */
  def getMaxHp: Int

  /**
   * Gets the total damage this unit can deal.
   * @return the total damage value
   */
  def getTotalDamage: Int

  /**
   * Gets the unique identifier of the unit.
   * @return the unit's ID
   */
  def getId: String

  /**
   * Moves the unit to a new panel.
   * @param newPanel the panel to move the unit to
   */
  def movePanel(newPanel: IPanel): Unit

  /**
   * Calculates the maximum value for the unit's action bar.
   * @return the calculated action bar maximum
   */
  def calculateActionBarMax: Double

  /**
   * Applies damage to the unit when attacked.
   * @param attackDmg the amount of damage to apply
   */
  def beAttacked(attackDmg: Int): Unit
}