package model.scheduler

/**
 * An interface defining the behavior of an action bar, which tracks the maximum and current values.
 */
trait IActionBar {
  /**
   * Sets the maximum value of the action bar.
   *
   * @param x The new maximum value of the action bar.
   */
  def setMax(x: Double): Unit

  /**
   * Sets the current value of the action bar.
   *
   * @param x The new current value of the action bar.
   */
  def setCurrent(x: Double): Unit

  /**
   * Retrieves a tuple containing the maximum and current values of the action bar.
   *
   * @return A tuple of (max, current) action bar values.
   */
  def getTuple: (Double, Double)

  /**
   * Retrieves the maximum value of the action bar.
   *
   * @return The maximum value of the action bar.
   */
  def getMax: Double

  /**
   * Retrieves the current value of the action bar.
   *
   * @return The current value of the action bar.
   */
  def getCurrent: Double
}
