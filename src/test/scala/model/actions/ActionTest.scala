package model.actions

import model.actions.Use.{Consume, Equip}
import model.items.Potions.ManaPotion
import model.items.Weapons.*
import munit.FunSuite

class ActionTest extends FunSuite{
  private val potion1 = new ManaPotion
  private val weapon1 = new Bow
  private val equip = new Equip
  private val consume = new Consume

  override def beforeEach(context: BeforeEach): Unit = {
    equip.setName("equip1")
  }

  test("An action has a name.") {
    assertEquals(equip.getName, "equip1")
  }
  
  //test("An action that uses items has to have a list of the objects that it can use.") {
  //}
}
