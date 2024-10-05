package model.panels

import api.GameObject
import model.units.Units

import scala.collection.mutable.ArrayBuffer


trait IPanel extends GameObject{
  def setCoordinates(x: Int, y: Int): Unit

  def setUnits(uArray: ArrayBuffer[Units]): Unit
  
  def setNorth(panel: Option[Panel]): Unit

  def setWest(panel: Option[Panel]): Unit

  def setSouth(panel: Option[Panel]): Unit

  def setEast(panel: Option[Panel]): Unit

  def getCoordinates: (Int, Int)

  def getUnits: ArrayBuffer[Units]

  def getNorth: Option[Panel]

  def getWest: Option[Panel]

  def getSouth: Option[Panel]

  def getEast: Option[Panel]
}
