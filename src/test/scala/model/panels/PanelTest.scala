package model.panels

import model.units.Enemy
import munit.FunSuite

class PanelTest extends FunSuite{
  var panel1: Panel = _
  var panel2: Panel = _
  var panel3: Panel = _
  var panel4: Panel = _
  var panelVacio: Panel = _
  var enemy1: Enemy = new Enemy()
  enemy1.setName("juan")
  enemy1.setHp(90)
  enemy1.setDp(60)
  enemy1.setWeight(30)
  enemy1.setAtk(40)
  val unitList: List[Unit] = List(enemy1)

  override def beforeEach(context: BeforeEach): Unit = {
    panel1 = new Panel
    panel2 = new Panel
    panel3 = new Panel
    panel4 = new Panel
    panelVacio = new Panel

    panelVacio.empty()

    panel1.setCoordinates(1, 1)
    panel1.setUnits(unitList)
    panel1.setNorth(panelVacio)
    panel1.setWest(panelVacio)
    panel1.setSouth(panel3)
    panel1.setEast(panel2)

    panel2.setCoordinates(2, 1)
    panel2.setUnits(unitList)
    panel2.setNorth(panelVacio)
    panel2.setWest(panel1)
    panel2.setSouth(panel4)
    panel2.setEast(panelVacio)

    panel3.setCoordinates(1, 2)
    panel3.setUnits(unitList)
    panel3.setNorth(panel1)
    panel3.setWest(panelVacio)
    panel3.setSouth(panelVacio)
    panel3.setEast(panel4)

    panel4.setCoordinates(2, 2)
    panel4.setUnits(unitList)
    panel4.setNorth(panel2)
    panel4.setWest(panel3)
    panel4.setSouth(panelVacio)
    panel4.setEast(panelVacio)
  }

  test("A panel has a set of coordinates.") {
    assertEquals(panel1.getCoordinates, (1, 1))
  }
  test("A panel has a list of units.") {
    assertEquals(panel1.getCoordinates, (1, 1))
  }
  test("A panel has to have a way to recognize its neighbours.") {
    assertEquals(panel1.getNorth, panelVacio)
    assertEquals(panel1.getWest, panelVacio)
    assertEquals(panel1.getSouth, panel3)
    assertEquals(panel1.getEast, panel2)

    assertEquals(panel4.getNorth, panel2)
    assertEquals(panel4.getWest, panel3)
    assertEquals(panel4.getSouth, panelVacio)
    assertEquals(panel4.getEast, panelVacio)
  }  
}
