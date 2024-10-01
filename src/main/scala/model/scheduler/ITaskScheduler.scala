package model.scheduler

import model.units.Units

import scala.collection.mutable

trait ITaskScheduler {

  def addUnit(unit: Units): Unit

  def removeUnit(unit: Units): Unit
  
  def getSchedulerContent: mutable.Map[Units, ActionBar]

  def calculateActionBarMax(): Unit

  def restartActionBar(unit: Units): Unit
  
  def increaseActionBars(k: Double): Unit

  def isActionBarComplete(unit: Units): Boolean

  def getCompleteActionBarUnits: List[Units]

  def getCurrentUnit: Units
  
}
