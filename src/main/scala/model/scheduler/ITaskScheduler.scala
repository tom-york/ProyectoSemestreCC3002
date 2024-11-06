package model.scheduler

import model.units.Units

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * An interface defining the behavior of a task scheduler, responsible for managing the action bars of game units.
 */
trait ITaskScheduler {
  /**
   * Adds a unit to the scheduler and initializes its action bar.
   *
   * @param unit The unit to be added to the scheduler.
   */
  def addUnit(unit: Units): Unit

  /**
   * Removes a unit from the scheduler.
   *
   * @param unit The unit to be removed from the scheduler.
   */
  def removeUnit(unit: Units): Unit

  /**
   * Retrieves the content of the scheduler, which is a map of units and their corresponding action bars.
   *
   * @return A mutable map of units and their action bars.
   */
  def getSchedulerContent: mutable.Map[Units, ActionBar]

  /**
   * Calculates and sets the maximum action bar value for each unit in the scheduler.
   */
  def calculateActionBarMax(): Unit

  /**
   * Resets the current action bar of a specific unit to zero.
   *
   * @param unit The unit whose action bar should be reset.
   */
  def restartActionBar(unit: Units): Unit

  /**
   * Increases the action bars of all units in the scheduler by a specified factor.
   *
   * @param k The factor by which to increase the action bars.
   */
  def increaseActionBars(k: Double): Unit

  /**
   * Checks if a unit's action bar is complete (current >= max).
   *
   * @param unit The unit to check.
   * @return `true` if the unit's action bar is complete, `false` otherwise.
   */
  def isActionBarComplete(unit: Units): Boolean

  /**
   * Retrieves a list of units whose action bars are complete, sorted by their surplus (current - max).
   *
   * @return An array buffer of units with complete action bars, sorted by their surplus.
   */
  def getCompleteActionBarUnits: ArrayBuffer[Units]

  /**
   * Retrieves the first unit with a complete action bar, sorted by proximity to completion.
   *
   * @return The unit with the first complete action bar.
   */
  def getCurrentUnit: Units
}
