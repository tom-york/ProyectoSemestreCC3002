package model.panels

import model.units.Units

class Panel {
  private var coordinates: (Int, Int) = _
  private var unitList: List[Units] = _
  private var neighbours: (Panel, Panel, Panel, Panel) = _ //change to immutable map
  
  def setCoordinates(x: Int, y: Int): Unit = {
    coordinates = (x, y)
  }
  
  def setUnits(uList: List[Units]): Unit = {
    unitList = uList
  }
}
