package model.players

import model.units.Units
import util.Json.{*, given}

import java.util.UUID

// Concrete class representing a player, implementing the IPlayer interface
class Player(private var unitList: List[Units]) extends IPlayer {
  
  private var defeatState: Boolean = false
  
  // Returns the list of units assigned to the player
  override def getUnitList: List[Units] = unitList

  // Returns the defeat state of the player (true if defeated, false otherwise)
  override def isDefeated: Boolean = defeatState

  override def setDefeatState(bool: Boolean): Unit = {
    defeatState = bool
  }

  // Returns the unique identifier of the player
  val id: String = UUID.randomUUID().toString

  // Serializes the player's data (including units) to JSON format
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "characters" -> JsArr(unitList.map(_.toJson)) // Converts unitList to JSON
  )
}
