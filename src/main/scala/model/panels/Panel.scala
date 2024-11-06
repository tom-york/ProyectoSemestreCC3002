package model.panels

import api.Target
import model.exceptions.{InvalidActionTarget, NotAdjacentPanel}
import model.units.{Units, characters}
import model.units.characters.MagicCharacter

import scala.collection.immutable.Map
import scala.collection.mutable.ArrayBuffer
import util.Json.{*, given}

import java.util.UUID

// Class representing a game panel, implementing the IPanel interface
class Panel extends IPanel with Target{
  private var coordinates: (Int, Int) = _ // Stores the coordinates of the panel
  private var unitArray: ArrayBuffer[Units] = _ // Stores the units present on the panel
  private var neighbours: Map[String, Option[Panel]] = Map.empty // Stores the neighboring panels
  neighbours = neighbours + ("north" -> None) + ("west" -> None) + ("south" -> None) + ("east" -> None)
  // Constructor for Panel with coordinates, units, and neighbors
  def this(c: (Int, Int), a: ArrayBuffer[Units]) = {
    this()
    coordinates = c
    unitArray = a
  }

  // Sets the coordinates of the panel
  def setCoordinates(x: Int, y: Int): Unit = {
    coordinates = (x, y)
  }

  // Sets the units present on the panel
  def setUnits(uArray: ArrayBuffer[Units]): Unit = {
    unitArray = uArray
  }

  // Sets the northern neighbor panel
  def setNorth(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("north" -> panel)
  }

  // Sets the western neighbor panel
  def setWest(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("west" -> panel)
  }

  // Sets the southern neighbor panel
  def setSouth(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("south" -> panel)
  }

  // Sets the eastern neighbor panel
  def setEast(panel: Option[Panel]): Unit = {
    neighbours = neighbours + ("east" -> panel)
  }

  // Retrieves the coordinates of the panel
  def getCoordinates: (Int, Int) = coordinates

  // Retrieves the units on the panel
  def getUnits: ArrayBuffer[Units] = unitArray

  // Retrieves the northern neighbor panel
  def getNeighbours: List[Panel] = neighbours.values.flatMap(_.toList).toList.distinct

  def addUnit(unit: Units): Unit = {
    unitArray.append(unit)
  }

  def removeUnit(unit: Units): Unit = {
    unitArray -= unit
  }

  // Returns the unique identifier of the panel
  val id: String = UUID.randomUUID().toString

  // Serializes the panel's data to JSON format
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "x" -> getCoordinates(0),
    "y" -> getCoordinates(1),
    "storage" -> JsArr(unitArray.map(_.toJson)) // Converts unitArray to JSON
  )

  // Checks if this panel is equal to another panel based on coordinates and units
  override def equals(other: Any): Boolean = {
    other match {
      case p: Panel => coordinates == p.getCoordinates && unitArray == p.getUnits
      case _ => false
    }
  }

  override def moveUnit(unit: Units): Unit = {
    if (unit.getPanel.getNeighbours.contains(this)) {
      unit.movePanel(this)
    }
    else {
      throw new NotAdjacentPanel(this)
    }
  }

  override def useMeteorite(magicCharacter: MagicCharacter): Unit = {
    val damageAmount: Int = magicCharacter.getMagicDamage
    unitArray.foreach(_.beAttacked(damageAmount))
  }

  override def beAttacked(attackDmg: Int): Unit = {
    throw new InvalidActionTarget("Panel", "Attack")
  }

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
