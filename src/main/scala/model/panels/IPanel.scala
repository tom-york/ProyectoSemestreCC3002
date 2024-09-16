package model.panels

import model.units.Units


trait IPanel {
  def setCoordinates(x: Int, y: Int): Unit

  def setUnits(uList: List[Units]): Unit
  
  def setNorth(panel: Panel): Unit

  def setWest(panel: Panel): Unit

  def setSouth(panel: Panel): Unit

  def setEast(panel: Panel): Unit

  def getCoordinates: (Int, Int)

  def getUnits: List[Units]

  def getNorth: Panel

  def getWest: Panel

  def getSouth: Panel

  def getEast: Panel
}
