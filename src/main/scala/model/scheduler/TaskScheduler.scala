package model.scheduler
import model.units.Units

import scala.collection.mutable


class TaskScheduler extends ITaskScheduler {

  private val schedulerMap: mutable.Map[Units, ActionBar] = mutable.Map()

  def addUnit(unit: Units): Unit = {
    schedulerMap += unit -> new ActionBar
  }

  def removeUnit(unit: Units): Unit = {
    schedulerMap -= unit
  }

  def getSchedulerContent: mutable.Map[Units, ActionBar] = schedulerMap

  def calculateActionBarMax(): Unit = ???

  def restartActionBar(unit: Units): Unit = {
    schedulerMap(unit).setCurrent(0.0)
  }

  def increaseActionBars(k: Double): Unit = ???

  def isActionBarComplete(unit: Units): Boolean = ???

  def getCompleteActionBarUnits: List[Units] = ???

  def getCurrentUnit: Units = ???

}
