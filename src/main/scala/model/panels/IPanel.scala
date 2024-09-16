package model.panels

import model.units.Units
import scala.collection.immutable.Map

trait IPanel {
  def setCoordinates(x: Int, y: Int): Unit

  def setUnits(uList: List[Units]): Unit
  
  def setNorth(panel: Panel): Unit

  def setWest(panel: Panel): Unit

  def setSouth(panel: Panel): Unit

  def setEast(panel: Panel): Unit
}
