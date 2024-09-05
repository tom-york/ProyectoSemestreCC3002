package model.players
import model.units.Units

class Player(unitList: List[Units], defeatState: Boolean) extends IPlayer {

  override def getUnitList: List[Units] = unitList

  override def isDefeated: Boolean = defeatState
  
}
