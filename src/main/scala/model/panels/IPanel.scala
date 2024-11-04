package model.panels

import api.GameObject
import model.units.Units

import scala.collection.mutable.ArrayBuffer

// Interface defining a panel in the game, extending GameObject
trait IPanel extends GameObject {
  def setCoordinates(x: Int, y: Int): Unit // Sets the coordinates of the panel

  def setUnits(uArray: ArrayBuffer[Units]): Unit // Sets the units present on the panel

  def setNorth(panel: Option[Panel]): Unit // Sets the northern neighbor panel

  def setWest(panel: Option[Panel]): Unit // Sets the western neighbor panel

  def setSouth(panel: Option[Panel]): Unit // Sets the southern neighbor panel

  def setEast(panel: Option[Panel]): Unit // Sets the eastern neighbor panel

  def getCoordinates: (Int, Int) // Retrieves the coordinates of the panel

  def getUnits: ArrayBuffer[Units] // Retrieves the units on the panel

  def getNeighbours: List[Panel] // Retrieves the northern neighbor panel
  
  def addUnit(unit: Units): Unit
  
  def removeUnit(unit: Units): Unit
}
