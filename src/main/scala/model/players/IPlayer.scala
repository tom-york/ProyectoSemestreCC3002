package model.players

import model.units.Units

trait IPlayer {

  def getUnitList: List[Units]

  def isDefeated: Boolean

}