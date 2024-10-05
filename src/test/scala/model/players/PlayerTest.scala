package model.players

import model.units.Enemy
import munit.FunSuite
import util.Json.{*, given}

class PlayerTest extends FunSuite {
  var player1: Player = _
  var player2: Player = _
  var enemy1: Enemy = _
  var enemy2: Enemy = _

  override def beforeEach(context: BeforeEach): Unit = {
    enemy1 = new Enemy("juan", 90, 60, 30, 40)
    
    enemy2 = new Enemy("john", 91, 61, 31, 41)
    
    player1 = new Player(List(), true)
    player2 = new Player(List(enemy1, enemy2), false)
  }

  test("A player has a list of units") {
    assertEquals(player1.getUnitList, List())
    assertEquals(player2.getUnitList, List(enemy1, enemy2))
  }

  test("A player can be defeated") {
    assertEquals(player1.isDefeated, true)
    assertEquals(player2.isDefeated, false)
  }

  test("Player JSON test") {
    val player2Json = JsObj(
      "id" -> "Player",
      "characters" -> JsArr(
        enemy1.toJson,
        enemy2.toJson
      )
    )
    assertEquals(player2.toJson, player2Json)
  }
}
