package model.units

import model.panels.Panel
import munit.FunSuite
import util.Json.{*, given}

import scala.collection.mutable.ArrayBuffer

class EnemyTest extends FunSuite {
  
  private var enemy: Enemy = _
  private var panel1: Panel = _

  override def beforeEach(context: BeforeEach): Unit = {
    panel1 = new Panel((1, 1), ArrayBuffer())
    enemy = new Enemy("juan", 90, 60, 30, panel1, 40)

  }
  
  test("An enemy has a name.") {
    assertEquals(enemy.getName, "juan")
  }

  test("An enemy has health points.") {
    assertEquals(enemy.getHp, 90)

  }

  test("An enemy has damage points.") {
    assertEquals(enemy.getDp, 60)
  }

  test("An enemy has a certain weight.") {
    assertEquals(enemy.getWeight, 30)
  }

  test("An enemy has attack points.") {
    assertEquals(enemy.getAtk, 40)
    enemy.setAtk(90)
    assertEquals(enemy.getAtk, 90)
  }

  test("An enemy can calculate the maximum for its action bar.") {
    assertEquals(enemy.calculateActionBarMax, 30.0)
  }

  test("Enemy JSON test") {
    val expectedJson = JsObj(
      "id" -> enemy.id,
      "attributes" -> JsArr(
        JsObj("name" -> "name", "value" -> "juan"),
        JsObj("name" -> "hp", "value" -> "90"),
        JsObj("name" -> "atk", "value" -> "40"),
        JsObj("name" -> "dp", "value" -> "60"),
        JsObj("name" -> "weight", "value" -> "30"))
      )
    assertEquals(enemy.toJson, expectedJson)
  }
}
