package model.panels

import model.units.{Enemy, Units}
import munit.FunSuite

class PanelTest extends FunSuite{
  var panel1: Panel = _
  var panel2: Panel = _
  var panel3: Panel = _
  var panel4: Panel = _
  var enemy1: Enemy = new Enemy()
  enemy1.setName("juan")
  enemy1.setHp(90)
  enemy1.setDp(60)
  enemy1.setWeight(30)
  enemy1.setAtk(40)
  val unitList: List[Units] = List(enemy1)

  override def beforeEach(context: BeforeEach): Unit = {
    panel1 = new Panel((1, 1), unitList, None, None, Some(panel3), Some(panel2))
    panel2 = new Panel((2, 1), unitList, None, Some(panel1), Some(panel4), None)
    panel3 = new Panel((1, 2), unitList, Some(panel1), None, None, Some(panel4))
    panel4 = new Panel((2, 2), unitList, Some(panel2), Some(panel3), None, None)
  }

  test("A panel has a set of coordinates.") {
    assertEquals(panel1.getCoordinates, (1, 1))
  }
  test("A panel has a list of units.") {
    assertEquals(panel1.getUnits, unitList)
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
  }  
}
