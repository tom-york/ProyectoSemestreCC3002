package model.players

import api.GameObject
import model.units.Units

trait IPlayer extends GameObject{

  def getUnitList: List[Units]

  def isDefeated: Boolean

}