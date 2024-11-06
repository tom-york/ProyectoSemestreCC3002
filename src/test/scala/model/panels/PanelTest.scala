package model.panels

import model.units.{Enemy, Units}
import munit.FunSuite
import scala.collection.mutable.ArrayBuffer
import util.Json.{*, given}

class PanelTest extends FunSuite{
  private var panel1: Panel = _
  private var panel2: Panel = _
  private var panel3: Panel = _
  private var panel4: Panel = _
  private var enemy1: Enemy = _

  override def beforeEach(context: BeforeEach): Unit = {
    panel1 = new Panel((1, 1), ArrayBuffer())
    panel2 = new Panel((2, 1), ArrayBuffer())
    panel3 = new Panel((1, 2), ArrayBuffer())
    panel4 = new Panel((2, 2), ArrayBuffer())
    panel1.setSouth(Some(panel3))
    panel1.setEast(Some(panel2))
    panel2.setWest(Some(panel1))
    panel2.setSouth(Some(panel4))
    panel3.setNorth(Some(panel1))
    panel3.setEast(Some(panel4))
    panel4.setNorth(Some(panel2))
    panel4.setWest(Some(panel3))

    enemy1 = new Enemy("juan", 90, 60, 30, panel1, 40)
  }

  test("A panel has a set of coordinates.") {
    assertEquals(panel1.getCoordinates, (1, 1))
    panel1.setCoordinates(3,3)
    assertEquals(panel1.getCoordinates, (3,3))
  }
  test("A panel has a list of units.") {
    assertEquals(panel2.getUnits, ArrayBuffer())
    assertEquals(panel1.getUnits, ArrayBuffer(enemy1))
    panel2.setUnits(ArrayBuffer(enemy1))
    assertEquals(panel2.getUnits, ArrayBuffer(enemy1))
  }
  test("A panel has to have a way to recognize its neighbours.") {
    assertEquals(panel1.getNeighbours, List(panel3, panel2))

    assertEquals(panel4.getNeighbours, List(panel2, panel3))

    panel1.setNorth(Some(panel4))
    panel1.setWest(Some(panel2))
    panel1.setSouth(None)
    panel1.setEast(None)

    assertEquals(panel1.getNeighbours, List(panel4, panel2))
  }

  test("Panel JSON test") {
    val panel1Json = JsObj(
      "id" -> panel1.id,
      "x" -> 1,
      "y" -> 1,
      "storage" -> JsArr(
        enemy1.toJson
      )
    )
    assertEquals(panel1.toJson, panel1Json)
  }

  test("Panel equals.") {
    val testPanel: Panel = Panel((1, 1), ArrayBuffer(enemy1))
    testPanel.setSouth(Some(panel3))
    testPanel.setEast(Some(panel2))
    assertEquals(panel1, testPanel)
    assert(!panel1.equals(panel2))
    assert(!panel1.equals(enemy1))
  }
}
