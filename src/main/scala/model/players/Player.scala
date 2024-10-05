package model.players

import model.units.Units
import util.Json.{*, given}

class Player(unitList: List[Units], defeatState: Boolean) extends IPlayer {

  override def getUnitList: List[Units] = unitList

  override def isDefeated: Boolean = defeatState

  override def id: String = "Player"

  override def toJson: JsObj = JsObj(
    "id" -> id,
    "characters" -> JsArr(unitList.map(_.toJson))
  )
}
