package model.scheduler

import model.units.Units

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

// Interface defining the task scheduler for managing units and their action bars
trait ITaskScheduler {

  def addUnit(unit: Units): Unit  // Adds a unit to the scheduler

  def removeUnit(unit: Units): Unit  // Removes a unit from the scheduler

  def getSchedulerContent: mutable.Map[Units, ActionBar]  // Returns the scheduler's content (units and action bars)

  def calculateActionBarMax(): Unit  // Calculates the max action bar for each unit

  def restartActionBar(unit: Units): Unit  // Resets the current action bar of a unit

  def increaseActionBars(k: Double): Unit  // Increases the action bars of all units by a factor `k`

  def isActionBarComplete(unit: Units): Boolean  // Checks if a unit's action bar is full

  def getCompleteActionBarUnits: ArrayBuffer[Units]  // Returns units with complete action bars

  def getCurrentUnit: Units  // Returns the current unit with a complete action bar

}

