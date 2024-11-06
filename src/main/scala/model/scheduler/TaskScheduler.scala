package model.scheduler
import model.exceptions.NoIdFound
import model.units.Units

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


// Concrete class implementing the task scheduler logic
class TaskScheduler extends ITaskScheduler {

  // Stores units and their corresponding action bars
  private val schedulerMap: mutable.Map[Units, ActionBar] = mutable.Map()

  // Adds a unit to the scheduler and initializes its action bar
  def addUnit(unit: Units): Unit = {
    schedulerMap += unit -> new ActionBar
  }

  // Removes a unit from the scheduler
  def removeUnit(unit: Units): Unit = {
    schedulerMap -= unit
  }

  // Returns the content of the scheduler (units and their action bars)
  def getSchedulerContent: mutable.Map[Units, ActionBar] = schedulerMap

  // Calculates and sets the max action bar for each unit
  def calculateActionBarMax(): Unit = {
    for ((unit, actionBar) <- schedulerMap) {
      actionBar.setMax(unit.calculateActionBarMax)
    }
  }

  // Resets the current action bar of a unit to zero
  def restartActionBar(unit: Units): Unit = {
    schedulerMap(unit).setCurrent(0.0)
  }

  // Increases the action bars of all units by a specified value `k`
  def increaseActionBars(k: Double): Unit = {
    for ((unit, actionBar) <- schedulerMap) {
      actionBar.increaseCurrent(k)
    }
  }

  // Checks if a unit's action bar is complete (current >= max)
  def isActionBarComplete(unit: Units): Boolean = {
    schedulerMap(unit).getCurrent >= schedulerMap(unit).getMax
  }

  // Returns a list of units whose action bars are complete, sorted by their surplus
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

  // Returns the first unit with a complete action bar (sorted by proximity to completion)
  def getCurrentUnit: Units = getCompleteActionBarUnits.head
}