package model.players

import model.panels.Panel
import model.units.Enemy
import munit.FunSuite
import util.Json.{*, given}

import scala.collection.mutable.ArrayBuffer

class PlayerTest extends FunSuite {
  private var panel1: Panel = _
  private var player1: Player = _
  private var player2: Player = _
  private var enemy1: Enemy = _
  private var enemy2: Enemy = _

  override def beforeEach(context: BeforeEach): Unit = {
    panel1 = new Panel((1, 1), ArrayBuffer())
    
    enemy1 = new Enemy("juan", 90, 60, 30, panel1, 40)
    
    enemy2 = new Enemy("john", 91, 61, 31, panel1, 41)
    
    player1 = new Player()
    player2 = new Player()

    player2.addUnit(enemy2)
    player2.addUnit(enemy1)
  }

  test("A player has a list of units") {
    assertEquals(player1.getUnitList, List())
    assertEquals(player2.getUnitList, List(enemy2, enemy1))
  }

  test("A player can be defeated") {
    assertEquals(player1.isDefeated, false)
    enemy1.setHp(0)
    enemy2.setHp(0)
    assertEquals(player2.isDefeated, true)
  }

  test("Player JSON test") {
    val player2Json = JsObj(
      "id" -> player2.id,
      "characters" -> JsArr(
        enemy2.toJson,
        enemy1.toJson
      )
    )
    assertEquals(player2.toJson, player2Json)
  }
}
