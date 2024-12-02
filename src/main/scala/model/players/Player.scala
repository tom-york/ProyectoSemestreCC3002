package model.players

import model.patterns.observer.ISubject
import model.units.Units
import util.Json.{*, given}

import scala.collection.mutable.Map
import java.util.UUID
import scala.collection.mutable

/**
 * A concrete class representing a player, implementing the IPlayer interface.
 *
 * The Player class maintains a list of units assigned to the player and the player's defeat state.
 *
 * @constructor Creates a new Player
 */
class Player extends IPlayer {
  private var defeatState: Boolean = false
  
  private val unitMap: mutable.Map[Units, Boolean] = mutable.Map()

  override def update(o: ISubject[Boolean], arg: Boolean): Unit = {
    o match
      case u: Units => unitMap(u) = arg
    val currentPlayerState: Boolean = unitMap.forall((_, value) => value)
    defeatState = currentPlayerState
    if (defeatState) {
      notifyObservers(true)
    }
  }

  override def addUnit(units: Units): Unit = {
    unitMap.put(units, false)
    units.registerObserver(this)
  }
  
  /**
   * Retrieves the list of units assigned to the player.
   *
   * @return The list of units assigned to the player.
   */
  override def getUnitList: List[Units] = unitMap.foldLeft(List[Units]())((acc, x) => acc :+ x(0))



  /**
   * Retrieves the defeat state of the player.
   *
   * @return `true` if the player is defeated, `false` otherwise.
   */
  override def isDefeated: Boolean = defeatState

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
    "characters" -> JsArr(getUnitList.map(_.toJson)) // Converts unitList to JSON
  )
}