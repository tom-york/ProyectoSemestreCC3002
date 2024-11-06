package model.panels

import api.Target
import model.exceptions.{InvalidActionTarget, NotAdjacentPanel}
import model.units.{Units, characters}
import model.units.characters.MagicCharacter

import scala.collection.immutable.Map
import scala.collection.mutable.ArrayBuffer
import util.Json.{*, given}

import java.util.UUID

/**
 * Represents a game panel on which units can be positioned and managed.
 * Implements the `IPanel` interface and extends the `Target` trait, inheriting necessary methods and properties.
 */
class Panel extends IPanel with Target {

  /** Stores the coordinates of the panel. */
  private var coordinates: (Int, Int) = _

  /** Stores the units present on the panel. */
  private var unitArray: ArrayBuffer[Units] = _

  /**
   * Stores the neighboring panels in a map with keys "north", "west", "south", and "east".
   * Each direction is initially set to None.
   */
  private var neighbours: Map[String, Option[Panel]] =
    Map("north" -> None, "west" -> None, "south" -> None, "east" -> None)

  /**
   * Constructor for `Panel`.
   * @param c the initial coordinates of the panel
   * @param a an ArrayBuffer of Units to place on the panel
   */
  def this(c: (Int, Int), a: ArrayBuffer[Units]) = {
    this()
    coordinates = c
    unitArray = a
  }

  /**
   * Sets the coordinates of the panel.
   * @param x the x-coordinate of the panel
   * @param y the y-coordinate of the panel
   */
  def setCoordinates(x: Int, y: Int): Unit = {
    coordinates = (x, y)
  }

  /**
   * Sets the units present on the panel.
   * @param uArray an ArrayBuffer of Units to place on the panel
   */
  def setUnits(uArray: ArrayBuffer[Units]): Unit = {
    unitArray = uArray
  }

  /**
   * Sets the northern neighboring panel.
   * @param panel an Option containing the panel to the north, or None if there is no neighbor
   */
  def setNorth(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("north" -> panel)
  }

  /**
   * Sets the western neighboring panel.
   * @param panel an Option containing the panel to the west, or None if there is no neighbor
   */
  def setWest(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("west" -> panel)
  }

  /**
   * Sets the southern neighboring panel.
   * @param panel an Option containing the panel to the south, or None if there is no neighbor
   */
  def setSouth(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("south" -> panel)
  }

  /**
   * Sets the eastern neighboring panel.
   * @param panel an Option containing the panel to the east, or None if there is no neighbor
   */
  def setEast(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("east" -> panel)
  }

  /**
   * Retrieves the coordinates of the panel.
   * @return a tuple containing the x and y coordinates
   */
  def getCoordinates: (Int, Int) = coordinates

  /**
   * Retrieves the units currently on the panel.
   * @return an ArrayBuffer of Units on the panel
   */
  def getUnits: ArrayBuffer[Units] = unitArray

  /**
   * Retrieves the list of neighboring panels.
   * @return a list of neighboring panels, excluding empty slots
   */
  def getNeighbours: List[Panel] = neighbours.values.flatMap(_.toList).toList.distinct

  /**
   * Adds a unit to the panel.
   * @param unit the unit to add to the panel
   */
  def addUnit(unit: Units): Unit = {
    unitArray.append(unit)
  }

  /**
   * Removes a unit from the panel.
   * @param unit the unit to remove from the panel
   */
  def removeUnit(unit: Units): Unit = {
    unitArray -= unit
  }

  /** A unique identifier for the panel, generated at creation. */
  val id: String = UUID.randomUUID().toString

  /**
   * Serializes the panel's data to JSON format.
   * @return a JsObj representing the panel's data in JSON format
   */
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "x" -> getCoordinates._1,
    "y" -> getCoordinates._2,
    "storage" -> JsArr(unitArray.map(_.toJson))
  )

  /**
   * Checks if this panel is equal to another panel based on coordinates and units.
   * @param other the object to compare with
   * @return true if the coordinates and units match, false otherwise
   */
  override def equals(other: Any): Boolean = {
    other match {
      case p: Panel => coordinates == p.getCoordinates && unitArray == p.getUnits
      case _ => false
    }
  }

  /**
   * Moves a unit to this panel if it is adjacent to the unit's current panel.
   * @param unit the unit to be moved
   * @throws NotAdjacentPanel if the unit's current panel is not adjacent to this panel
   */
  override def moveUnit(unit: Units): Unit = {
    if (unit.getPanel.getNeighbours.contains(this)) {
      unit.movePanel(this)
    } else {
      throw new NotAdjacentPanel(this)
    }
  }

  /**
   * Causes all units on this panel to take damage from a meteorite attack.
   * @param magicCharacter the character casting the meteorite spell
   */
  override def useMeteorite(magicCharacter: MagicCharacter): Unit = {
    val damageAmount: Int = magicCharacter.getMagicDamage
    unitArray.foreach(_.beAttacked(damageAmount))
  }

  /**
   * Throws an exception, as panels cannot be attacked.
   * @param attackDmg the damage attempted to be inflicted (not used)
   */
  override def beAttacked(attackDmg: Int): Unit = {
    throw new InvalidActionTarget("Panel", "Attack")
  }

  /** Other methods for actions that cannot be performed on panels, all throw exceptions */
  override def characterConsume(character: characters.Character): Unit = {
    throw new InvalidActionTarget("Panel", "Consume")
  }

  override def magicCharacterConsume(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Panel", "Consume")
  }

  override def equipWeapon(character: characters.Character): Unit = {
    throw new InvalidActionTarget("Panel", "Equip")
  }

  override def healCharacter(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Panel", "Heal")
  }

  override def purifyEnemy(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Panel", "Purify")
  }

  override def useThunder(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Panel", "Thunder")
  }
}
