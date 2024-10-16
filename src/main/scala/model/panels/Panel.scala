package model.panels

import model.units.Units

import scala.collection.immutable.Map
import scala.collection.mutable.ArrayBuffer
import util.Json.{*, given}
import java.util.UUID

// Class representing a game panel, implementing the IPanel interface
class Panel extends IPanel {
  private var coordinates: (Int, Int) = _ // Stores the coordinates of the panel
  private var unitArray: ArrayBuffer[Units] = _ // Stores the units present on the panel
  private var neighbours: Map[String, Option[Panel]] = Map.empty // Stores the neighboring panels

  // Constructor for Panel with coordinates, units, and neighbors
  def this(c: (Int, Int), a: ArrayBuffer[Units], north: Option[Panel], west: Option[Panel], south: Option[Panel], east: Option[Panel]) = {
    this()
    coordinates = c
    unitArray = a
    neighbours = neighbours + ("north" -> north) + ("west" -> west) + ("south" -> south) + ("east" -> east)
  }

  // Sets the coordinates of the panel
  def setCoordinates(x: Int, y: Int): Unit = {
    coordinates = (x, y)
  }

  // Sets the units present on the panel
  def setUnits(uArray: ArrayBuffer[Units]): Unit = {
    unitArray = uArray
  }

  // Sets the northern neighbor panel
  def setNorth(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("north" -> panel)
  }

  // Sets the western neighbor panel
  def setWest(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("west" -> panel)
  }

  // Sets the southern neighbor panel
  def setSouth(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("south" -> panel)
  }

  // Sets the eastern neighbor panel
  def setEast(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("east" -> panel)
  }

  // Retrieves the coordinates of the panel
  def getCoordinates: (Int, Int) = coordinates

  // Retrieves the units on the panel
  def getUnits: ArrayBuffer[Units] = unitArray

  // Retrieves the northern neighbor panel
  def getNorth: Option[Panel] = neighbours("north")

  // Retrieves the western neighbor panel
  def getWest: Option[Panel] = neighbours("west")

  // Retrieves the southern neighbor panel
  def getSouth: Option[Panel] = neighbours("south")

  // Retrieves the eastern neighbor panel
  def getEast: Option[Panel] = neighbours("east")

  // Returns the unique identifier of the panel
  protected val id: String = UUID.randomUUID().toString

  override def getID: String = id
  
  // Serializes the panel's data to JSON format
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "x" -> getCoordinates(0),
    "y" -> getCoordinates(1),
    "storage" -> JsArr(unitArray.map(_.toJson)) // Converts unitArray to JSON
  )

  // Checks if this panel is equal to another panel based on coordinates and units
  override def equals(other: Any): Boolean = {
    other match {
      case p: Panel => coordinates == p.getCoordinates && unitArray == p.getUnits
      case _ => false
    }
  }
}
