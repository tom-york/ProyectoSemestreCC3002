package model.scheduler

class ActionBar extends IActionBar {

  private var max: Double = 0.0

  private var current: Double = 0.0

  def setMax(x: Double): Unit = {
    max = x
  }

  def setCurrent(x: Double): Unit = {
    current = x
  }
  
  def increaseCurrent(x: Double): Unit = {
    current += x
  }

  def getTuple: (Double, Double) = (max, current)

  def getMax: Double = max

  def getCurrent: Double = current
  
}
