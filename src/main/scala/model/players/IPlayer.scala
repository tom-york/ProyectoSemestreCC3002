package model.players

import api.GameObject
import model.units.Units

/**
 * An interface defining a player in the game, extending the `GameObject` interface.
 */
trait IPlayer extends GameObject {
  /**
   * Retrieves the list of units belonging to the player.
   *
   * @return The list of units assigned to the player.
   */
  def getUnitList: List[Units]

  /**
   * Sets the defeat state of the player.
   *
   * @param bool The new defeat state of the player (true if defeated, false otherwise).
   */
  def setDefeatState(bool: Boolean): Unit

  /**
   * Checks if the player is defeated.
   *
   * @return `true` if the player is defeated, `false` otherwise.
   */
  def isDefeated: Boolean
}