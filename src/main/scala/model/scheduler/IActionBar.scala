package model.scheduler

// Interface defining the action bar, which tracks max and current values
trait IActionBar {
  def setMax(x: Double): Unit  // Sets the maximum value of the action bar

  def setCurrent(x: Double): Unit  // Sets the current value of the action bar

  def getTuple: (Double, Double)  // Retrieves a tuple of (max, current) action bar values

  def getMax: Double  // Returns the maximum action bar value

  def getCurrent: Double  // Returns the current action bar value
}
