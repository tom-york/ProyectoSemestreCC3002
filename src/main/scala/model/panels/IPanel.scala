package model.panels

import model.units.Units


trait IPanel {
  def setCoordinates(x: Int, y: Int): Unit

  def setUnits(uList: List[Units]): Unit
  
  def setNorth(panel: Option[Panel]): Unit

  def setWest(panel: Option[Panel]): Unit

  def setSouth(panel: Option[Panel]): Unit

  def setEast(panel: Option[Panel]): Unit

  def getCoordinates: (Int, Int)

  def getUnits: List[Units]

  def getNorth: Option[Panel]

  def getWest: Option[Panel]

  def getSouth: Option[Panel]

  def getEast: Option[Panel]
}
