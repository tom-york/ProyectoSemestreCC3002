package model.scheduler
import model.units.Units

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


class TaskScheduler extends ITaskScheduler {

  private val schedulerMap: mutable.Map[Units, ActionBar] = mutable.Map()

  def addUnit(unit: Units): Unit = {
    schedulerMap += unit -> new ActionBar
  }

  def removeUnit(unit: Units): Unit = {
    schedulerMap -= unit
  }

  def getSchedulerContent: mutable.Map[Units, ActionBar] = schedulerMap

  def calculateActionBarMax(): Unit = {
    for ((unit, actionBar) <- schedulerMap) {
      actionBar.setMax(unit.calculateActionBarMax)
    }
  }

  def restartActionBar(unit: Units): Unit = {
    schedulerMap(unit).setCurrent(0.0)
  }

  def increaseActionBars(k: Double): Unit = {
    for ((unit, actionBar) <- schedulerMap) {
      actionBar.increaseCurrent(k)
    }
  }

  def isActionBarComplete(unit: Units): Boolean = {
    if (schedulerMap(unit).getCurrent >= schedulerMap(unit).getMax) {
      true
    }
    else false
  }

  def getCompleteActionBarUnits: ArrayBuffer[Units] = {
    var completedArray: ArrayBuffer[Units] = ArrayBuffer()
    for ((unit, actionBar) <- schedulerMap) {
      if (isActionBarComplete(unit)) {
      }
    }
    completedArray
  }

  def getCurrentUnit: Units = getCompleteActionBarUnits.head
}
