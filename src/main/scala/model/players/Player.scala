package model.players

import model.panels.Panel
import model.patterns.factory.character.{ArcherFactory, BlackWizardFactory, CharacterFactory, KnightFactory, ThiefFactory, WhiteWizardFactory}
import model.units.characters.Character
import model.patterns.observer.ISubject
import model.units.Units
import util.Json.{*, given}

import scala.collection.mutable.Map
import java.util.UUID
import scala.collection.mutable
import scala.util.Random

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
  
  private val compatibleCharacterFactories: List[CharacterFactory] = List(ArcherFactory, BlackWizardFactory, KnightFactory, ThiefFactory, WhiteWizardFactory)

  /** Initializes the player with a set of randomly selected characters on the given panel.
   *
   * Creates 3 characters from a predefined list of character factories,
   * randomly selecting their types and placing them on the specified panel.
   *
   * @param panel The game panel where characters will be initialized
   */
  override def init(panel: Panel): Unit = {
    for (x <- 0 until 3) {
      val u: Character = compatibleCharacterFactories(Random.between(0, 5))(panel)
      u.init()
      addUnit(u)
    }
  }

  /** Updates the player's state based on the defeat status of its units.
   *
   * When a unit is defeated, this method updates the player's overall defeat state.
   * If all units are defeated, it notifies observers of the player's defeat.
   *
   * @param o   The subject (unit) sending the update
   * @param arg Boolean indicating the unit's defeat status
   */
  override def update(o: ISubject[Boolean], arg: Boolean): Unit = {
    o match
      case u: Units => unitMap(u) = arg
    val currentPlayerState: Boolean = unitMap.forall((_, value) => value)
    defeatState = currentPlayerState
    if (defeatState) {
      notifyObservers(true)
    }
  }

  /** Adds a unit to the player's unit map and registers the player as an observer.
   *
   * @param units The game unit to be added to the player's units
   */
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