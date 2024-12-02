package model.players

import api.GameObject
import model.panels.Panel
import model.patterns.observer.{Observer, Subject}
import model.units.Units

/**
 * An interface defining a player in the game, extending the `GameObject` interface.
 */
trait IPlayer extends Subject[Boolean] with GameObject with Observer[Boolean]{
  
  def init(panel: Panel): Unit
  
  /**
   * Retrieves the list of units belonging to the player.
   *
   * @return The list of units assigned to the player.
   */
  def getUnitList: List[Units]

  /**
   * Checks if the player is defeated.
   *
   * @return `true` if the player is defeated, `false` otherwise.
   */
  def isDefeated: Boolean
  
  def addUnit(units: Units): Unit
}