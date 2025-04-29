package model.panels

import api.GameObject
import model.units.Units

import scala.collection.mutable.ArrayBuffer

/**
 * Interface defining a panel in the game, representing a location where units can be positioned.
 * Extends the GameObject trait to inherit basic game object properties.
 */
trait IPanel extends GameObject {

  /**
   * Sets the coordinates of the panel.
   * @param x the x-coordinate of the panel
   * @param y the y-coordinate of the panel
   */
  def setCoordinates(x: Int, y: Int): Unit

  /**
   * Sets the units present on the panel.
   * @param uArray an ArrayBuffer of Units to place on the panel
   */
  def setUnits(uArray: ArrayBuffer[Units]): Unit

  /**
   * Sets the northern neighboring panel.
   * @param panel an Option containing the panel to the north, or None if there is no neighbor
   */
  def setNorth(panel: Option[Panel]): Unit

  /**
   * Sets the western neighboring panel.
   * @param panel an Option containing the panel to the west, or None if there is no neighbor
   */
  def setWest(panel: Option[Panel]): Unit

  /**
   * Sets the southern neighboring panel.
   * @param panel an Option containing the panel to the south, or None if there is no neighbor
   */
  def setSouth(panel: Option[Panel]): Unit

  /**
   * Sets the eastern neighboring panel.
   * @param panel an Option containing the panel to the east, or None if there is no neighbor
   */
  def setEast(panel: Option[Panel]): Unit

  /**
   * Retrieves the coordinates of the panel.
   * @return a tuple containing the x and y coordinates
   */
  def getCoordinates: (Int, Int)

  /**
   * Retrieves the units currently on the panel.
   * @return an ArrayBuffer of Units on the panel
   */
  def getUnits: ArrayBuffer[Units]

  /**
   * Retrieves the list of neighboring panels (north, west, south, east).
   * @return a list of neighboring panels in a specific order: [north, west, south, east]
   */
  def getNeighbours: List[Panel]

  /**
   * Adds a unit to the panel.
   * @param unit the unit to add to the panel
   */
  def addUnit(unit: Units): Unit

  /**
   * Removes a unit from the panel.
   * @param unit the unit to remove from the panel
   */
  def removeUnit(unit: Units): Unit
}
