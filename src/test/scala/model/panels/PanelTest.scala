package model.panels

import model.units.{Enemy, Units}
import munit.FunSuite
import scala.collection.mutable.ArrayBuffer
import util.Json.{*, given}

class PanelTest extends FunSuite{
  var panel1: Panel = _
  var panel2: Panel = _
  var panel3: Panel = _
  var panel4: Panel = _
  var enemy1: Enemy = new Enemy("juan", 90, 60, 30, 40)
  val unitArray: ArrayBuffer[Units] = ArrayBuffer(enemy1)

  override def beforeEach(context: BeforeEach): Unit = {
    panel1 = new Panel((1, 1), unitArray, None, None, Some(panel3), Some(panel2))
    panel2 = new Panel((2, 1), unitArray, None, Some(panel1), Some(panel4), None)
    panel3 = new Panel((1, 2), unitArray, Some(panel1), None, None, Some(panel4))
    panel4 = new Panel((2, 2), unitArray, Some(panel2), Some(panel3), None, None)
  }

  test("A panel has a set of coordinates.") {
    assertEquals(panel1.getCoordinates, (1, 1))
    panel1.setCoordinates(3,3)
    assertEquals(panel1.getCoordinates, (3,3))
  }
  test("A panel has a list of units.") {
    assertEquals(panel1.getUnits, unitArray)
    panel1.setUnits(ArrayBuffer())
    assertEquals(panel1.getUnits, ArrayBuffer())
  }
  test("A panel has to have a way to recognize its neighbours.") {
    assertEquals(panel1.getNorth, None)
    assertEquals(panel1.getWest, None)
    assertEquals(panel1.getSouth, Some(panel3))
    assertEquals(panel1.getEast, Some(panel2))

    assertEquals(panel4.getNorth, Some(panel2))
    assertEquals(panel4.getWest, Some(panel3))
    assertEquals(panel4.getSouth, None)
    assertEquals(panel4.getEast, None)

    panel1.setNorth(Some(panel3))
    panel1.setWest(Some(panel2))
    panel1.setSouth(None)
    panel1.setEast(None)

    assertEquals(panel1.getNorth, Some(panel3))
    assertEquals(panel1.getWest, Some(panel2))
    assertEquals(panel1.getSouth, None)
    assertEquals(panel1.getEast, None)
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
    val testPanel = Panel((1, 1), unitArray, None, None, Some(panel3), Some(panel2))
    assertEquals(panel1, testPanel)
    assert(!panel1.equals(panel2))
    assert(!panel1.equals(enemy1))
  }
}
