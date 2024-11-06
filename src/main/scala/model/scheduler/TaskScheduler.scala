package model.scheduler
import model.exceptions.NoIdFound
import model.units.Units

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


/**
 * A concrete class that implements the ITaskScheduler interface, responsible for managing the action bars of game units.
 *
 * The TaskScheduler class maintains a map of units and their corresponding action bars, and provides methods to add, remove, and manage the units and their action bars.
 *
 * @constructor Creates a new TaskScheduler instance.
 */
class TaskScheduler extends ITaskScheduler {
  private val schedulerMap: mutable.Map[Units, ActionBar] = mutable.Map()

  /**
   * Adds a unit to the scheduler and initializes its action bar.
   *
   * @param unit The unit to be added to the scheduler.
   */
  def addUnit(unit: Units): Unit = {
    schedulerMap += unit -> new ActionBar
  }

  /**
   * Removes a unit from the scheduler.
   *
   * @param unit The unit to be removed from the scheduler.
   */
  def removeUnit(unit: Units): Unit = {
    schedulerMap -= unit
  }

  /**
   * Retrieves the content of the scheduler, which is a map of units and their corresponding action bars.
   *
   * @return A mutable map of units and their action bars.
   */
  def getSchedulerContent: mutable.Map[Units, ActionBar] = schedulerMap

  /**
   * Calculates and sets the maximum action bar value for each unit in the scheduler.
   */
  def calculateActionBarMax(): Unit = {
    for ((unit, actionBar) <- schedulerMap) {
      actionBar.setMax(unit.calculateActionBarMax)
    }
  }

  /**
   * Resets the current action bar of a specific unit to zero.
   *
   * @param unit The unit whose action bar should be reset.
   */
  def restartActionBar(unit: Units): Unit = {
    schedulerMap(unit).setCurrent(0.0)
  }

  /**
   * Increases the action bars of all units in the scheduler by a specified factor.
   *
   * @param k The factor by which to increase the action bars.
   */
  def increaseActionBars(k: Double): Unit = {
    for ((unit, actionBar) <- schedulerMap) {
      actionBar.increaseCurrent(k)
    }
  }

  /**
   * Checks if a unit's action bar is complete (current >= max).
   *
   * @param unit The unit to check.
   * @return `true` if the unit's action bar is complete, `false` otherwise.
   */
  def isActionBarComplete(unit: Units): Boolean = {
    schedulerMap(unit).getCurrent >= schedulerMap(unit).getMax
  }

  /**
   * Retrieves a list of units whose action bars are complete, sorted by their surplus (current - max).
   *
   * @return An array buffer of units with complete action bars, sorted by their surplus.
   */
  def getCompleteActionBarUnits: ArrayBuffer[Units] = {
    var completedArray: ArrayBuffer[(Units, ActionBar)] = ArrayBuffer()
    for ((unit, actionBar) <- schedulerMap) {
      if (isActionBarComplete(unit)) {
        completedArray.append((unit, actionBar))
      }
    }
    completedArray = completedArray.sortBy(element => -(element._2.getCurrent - element._2.getMax))
    completedArray.map(_._1)  // Return only the units
  }

  /**
   * Retrieves the first unit with a complete action bar, sorted by proximity to completion.
   *
   * @return The unit with the first complete action bar.
   */
  def getCurrentUnit: Units = getCompleteActionBarUnits.head
}