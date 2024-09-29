package model.panels

import model.units.Units
import scala.collection.immutable.Map

class Panel extends IPanel {
  private var coordinates: (Int, Int) = _
  private var unitList: List[Units] = _
  private var neighbours: Map[String, Option[Panel]] = Map.empty

  def this(c: (Int, Int), l: List[Units], north: Option[Panel], west: Option[Panel], south: Option[Panel], east: Option[Panel]) = {
    this()
    coordinates = c
    unitList = l
    neighbours = neighbours + ("north" -> north) + ("west" -> west) + ("south" -> south) + ("east" -> east)
  }

  def setCoordinates(x: Int, y: Int): Unit = {
    coordinates = (x, y)
  }
  
  def setUnits(uList: List[Units]): Unit = {
    unitList = uList
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

  def getUnits: List[Units] = unitList
  
  def getNorth: Option[Panel] = neighbours("north")

  def getWest: Option[Panel] = neighbours("west")

  def getSouth: Option[Panel] = neighbours("south")

  def getEast: Option[Panel] = neighbours("east")

  override def equals(other: Any): Boolean = {
    other match {
      case p: Panel => coordinates == p.getCoordinates && unitList == p.getUnits
      case _ => false
    }
  }
}
