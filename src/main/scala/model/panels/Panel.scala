package model.panels

import model.units.Units

import scala.collection.immutable.Map
import scala.collection.mutable.ArrayBuffer
import util.Json.{*, given}

class Panel extends IPanel {
  private var coordinates: (Int, Int) = _
  private var unitArray: ArrayBuffer[Units] = _
  private var neighbours: Map[String, Option[Panel]] = Map.empty

  def this(c: (Int, Int), a: ArrayBuffer[Units], north: Option[Panel], west: Option[Panel], south: Option[Panel], east: Option[Panel]) = {
    this()
    coordinates = c
    unitArray = a
    neighbours = neighbours + ("north" -> north) + ("west" -> west) + ("south" -> south) + ("east" -> east)
  }

  def setCoordinates(x: Int, y: Int): Unit = {
    coordinates = (x, y)
  }
  
  def setUnits(uArray: ArrayBuffer[Units]): Unit = {
    unitArray = uArray
  }

  def setNorth(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("north" -> panel)
  }

  def setWest(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("west" -> panel)
  }

  def setSouth(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("south" -> panel)
  }

  def setEast(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("east" -> panel)
  }

  def getCoordinates: (Int, Int) = coordinates

  def getUnits: ArrayBuffer[Units] = unitArray
  
  def getNorth: Option[Panel] = neighbours("north")

  def getWest: Option[Panel] = neighbours("west")

  def getSouth: Option[Panel] = neighbours("south")

  def getEast: Option[Panel] = neighbours("east")

  override def id: String = "Panel"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "x" -> getCoordinates(0),
    "y" -> getCoordinates(1),
    "storage" -> JsArr(unitArray.map(_.toJson))
  )

  override def equals(other: Any): Boolean = {
    other match {
      case p: Panel => coordinates == p.getCoordinates && unitArray == p.getUnits
      case _ => false
    }
  }
}
