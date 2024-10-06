package model.players

import model.units.Units
import util.Json.{*, given}

// Concrete class representing a player, implementing the IPlayer interface
class Player(unitList: List[Units], defeatState: Boolean) extends IPlayer {

  // Returns the list of units assigned to the player
  override def getUnitList: List[Units] = unitList

  // Returns the defeat state of the player (true if defeated, false otherwise)
  override def isDefeated: Boolean = defeatState

  // Returns the unique identifier of the player
  override def id: String = "Player"

  // Serializes the player's data (including units) to JSON format
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "characters" -> JsArr(unitList.map(_.toJson)) // Converts unitList to JSON
  )
}
