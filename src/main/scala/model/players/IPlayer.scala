package model.players

import api.GameObject
import model.units.Units

// Interface defining a player in the game, extending GameObject
trait IPlayer extends GameObject {

  // Retrieves the list of units belonging to the player
  def getUnitList: List[Units]

  def getID: String

  // Checks if the player is defeated
  def isDefeated: Boolean
}