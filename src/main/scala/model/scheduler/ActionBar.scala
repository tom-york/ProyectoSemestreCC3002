package model.scheduler

// Concrete class implementing the action bar logic
class ActionBar extends IActionBar {

  private var max: Double = 0.0  // Maximum value of the action bar
  private var current: Double = 0.0  // Current value of the action bar

  // Sets the maximum value of the action bar
  def setMax(x: Double): Unit = {
    max = x
  }

  // Sets the current value of the action bar
  def setCurrent(x: Double): Unit = {
    current = x
  }

  // Increases the current value of the action bar
  def increaseCurrent(x: Double): Unit = {
    current += x
  }

  // Returns a tuple containing the max and current values of the action bar
  def getTuple: (Double, Double) = (max, current)

  // Returns the maximum action bar value
  def getMax: Double = max

  // Returns the current action bar value
  def getCurrent: Double = current
}

