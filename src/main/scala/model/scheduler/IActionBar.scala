package model.scheduler

trait IActionBar {
  def setMax(x: Double): Unit

  def setCurrent(x: Double): Unit
  
  def getTuple: (Double, Double)
  
  def getMax: Double
  
  def getCurrent: Double
}
