package model.players

import model.units.Units

trait Player {

  def getUnitList: List[Units]

  def isDefeated: Boolean

}