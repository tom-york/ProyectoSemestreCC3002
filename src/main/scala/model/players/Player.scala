package model.players

import model.units.Units
import util.Json.{*, given}

import java.util.UUID

/**
 * A concrete class representing a player, implementing the IPlayer interface.
 *
 * The Player class maintains a list of units assigned to the player and the player's defeat state.
 *
 * @param unitList The list of units assigned to the player.
 * @constructor Creates a new Player instance with the specified list of units.
 */
class Player(private var unitList: List[Units]) extends IPlayer {
  private var defeatState: Boolean = false

  /**
   * Retrieves the list of units assigned to the player.
   *
   * @return The list of units assigned to the player.
   */
  override def getUnitList: List[Units] = unitList

  /**
   * Retrieves the defeat state of the player.
   *
   * @return `true` if the player is defeated, `false` otherwise.
   */
  override def isDefeated: Boolean = defeatState

  /**
   * Sets the defeat state of the player.
   *
   * @param bool The new defeat state of the player.
   */
  override def setDefeatState(bool: Boolean): Unit = {
    defeatState = bool
  }

  /**
   * Retrieves the unique identifier of the player.
   *
   * @return The unique identifier of the player.
   */
  val id: String = UUID.randomUUID().toString

  /**
   * Serializes the player's data (including units) to JSON format.
   *
   * @return A JSON object representing the player's data.
   */
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "characters" -> JsArr(unitList.map(_.toJson)) // Converts unitList to JSON
  )
}