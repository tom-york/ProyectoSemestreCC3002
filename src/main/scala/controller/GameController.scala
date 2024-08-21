package controller

import api.{GameApi, IGameController}
import util.Json.{*, given}

object GameController extends IGameController {
  /* write your code here */
  val character1: JsObj = JsObj(
    "id" -> "c1",
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> "Relm"),
      JsObj("name" -> "hp", "value" -> "100"),
      JsObj("name" -> "atk", "value" -> "50"),
    ),
    "img" -> "Relm.gif"
  )

  val character2: JsObj = JsObj(
    "id" -> "c2",
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> "Setzer"),
      JsObj("name" -> "hp", "value" -> "150"),
      JsObj("name" -> "atk", "value" -> "40"),
      JsObj("name" -> "def", "value" -> "10"),

    ),
    "img" -> "Setzer.gif"
  )

  val character3: JsObj = JsObj(
    "id" -> "c3",
    "attributes" -> JsArr(
      JsObj("name" -> "name", "value" -> "Terra"),
      JsObj("name" -> "hp", "value" -> "200"),
      JsObj("name" -> "atk", "value" -> "30"),
      JsObj("name" -> "def", "value" -> "20"),
      JsObj("name" -> "mp", "value" -> "20"),
    ),
    "img" -> "Terra.gif"
  )

  val panel1: JsObj = JsObj(
    "id" -> "p1",
    "x" -> 1,
    "y" -> 1,
    "storage" -> JsArr(
      "c1"
    )
  )

  val panel2: JsObj = JsObj(
    "id" -> "p2",
    "x" -> 2,
    "y" -> 1,
    "storage" -> JsArr(
      "c2"
    )
  )

  val panel3: JsObj = JsObj(
    "id" -> "p3",
    "x" -> 2,
    "y" -> 2,
    "storage" -> JsArr()
  )

  val panel4: JsObj = JsObj(
    "id" -> "p4",
    "x" -> 1,
    "y" -> 2,
    "storage" -> JsArr(
      "c3"
    )
  )

  val player1: JsObj = JsObj(
    "characters" -> JsArr(
      character1,
      character2,
      character3
    )
  )

  val player2: JsObj = JsObj(
    "characters" -> JsArr()
  )

  /** Returns the players of the game. In this version of the project, there are
   * strictly two players. Each player should send the information of his game
   * units.
   */
  def getPlayers: JsVal = {
    JsArr(
      player1,
      player2
    )
  }

  /** Returns the game panels. These panels are basically the map where the game
   * units will be interacting with.
   */
  def getGamePanels: JsVal = {
    JsArr(
      panel1,
      panel2,
      panel3,
      panel4
    )
  }

  /** Returns the id of the current game unit. The current game unit is the unit
   * that can do actions, in other words, it's their turn.
   */

  var currentGameUnitId: String = "c1"

  def getCurrentGameUnitId: String = currentGameUnitId

  def main(args: Array[String]): Unit = {

    GameApi.run(args)

  }
}

