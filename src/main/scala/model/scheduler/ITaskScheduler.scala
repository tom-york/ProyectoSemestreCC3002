package model.scheduler

import model.units.Units

trait ITaskScheduler {

  def addUnit(units: Units): Unit

  def removeUnit(unit: Units): Unit

  def calculateActionBarMax(): Unit

  def restartActionBar(unit: Units): Unit
  
  def increaseActionBars(): Unit

  def isActionBarComplete(unit: Units): Boolean

  def getCompleteActionBarUnits: List[Units]

  def getCurrentUnit: Units
  
}
