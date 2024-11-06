package model.scheduler

/**
 * A concrete class that implements the IActionBar interface, responsible for managing the action bar for game units.
 *
 * The action bar tracks the maximum value and the current value, and provides methods to set, increase, and retrieve these values.
 *
 * @constructor Creates a new ActionBar instance.
 */
class ActionBar extends IActionBar {
  private var max: Double = 0.0  // Maximum value of the action bar
  private var current: Double = 0.0  // Current value of the action bar

  /**
   * Sets the maximum value of the action bar.
   *
   * @param x The new maximum value of the action bar.
   */
  def setMax(x: Double): Unit = {
    max = x
  }

  /**
   * Sets the current value of the action bar.
   *
   * @param x The new current value of the action bar.
   */
  def setCurrent(x: Double): Unit = {
    current = x
  }

  /**
   * Increases the current value of the action bar by the specified amount.
   *
   * @param x The amount to increase the current value by.
   */
  def increaseCurrent(x: Double): Unit = {
    current += x
  }

  /**
   * Retrieves a tuple containing the maximum and current values of the action bar.
   *
   * @return A tuple of (max, current) action bar values.
   */
  def getTuple: (Double, Double) = (max, current)

  /**
   * Retrieves the maximum value of the action bar.
   *
   * @return The maximum value of the action bar.
   */
  def getMax: Double = max

  /**
   * Retrieves the current value of the action bar.
   *
   * @return The current value of the action bar.
   */
  def getCurrent: Double = current
}

