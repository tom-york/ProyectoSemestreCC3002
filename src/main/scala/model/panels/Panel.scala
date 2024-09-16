package model.panels

import model.units.Units
import scala.collection.immutable.Map

class Panel extends IPanel {
  private var coordinates: (Int, Int) = _
  private var unitList: List[Units] = _
  private var neighbours: Map[String, Panel] = Map.empty //change to immutable map
  private var isEmpty: Boolean = false
  
  def setCoordinates(x: Int, y: Int): Unit = {
    coordinates = (x, y)
  }
  
  def setUnits(uList: List[Units]): Unit = {
    unitList = uList
  }

  def setNorth(panel: Panel): Unit = {
    neighbours = neighbours + ("north" -> panel)
  }

  def setWest(panel: Panel): Unit = {
    neighbours = neighbours + ("west" -> panel)
  }

  def setSouth(panel: Panel): Unit = {
    neighbours = neighbours + ("south" -> panel)
  }

  def setEast(panel: Panel): Unit = {
    neighbours = neighbours + ("east" -> panel)
  }
  
  def empty(sel: Boolean): Unit = {
    isEmpty = sel
  }

  def getCoordinates: (Int, Int) = coordinates

  def getUnits: List[Units] = unitList
  
  def getNorth: Panel = neighbours("north")

  def getWest: Panel = neighbours("west")

  def getSouth: Panel = neighbours("south")

  def getEast: Panel = neighbours("east")
}
