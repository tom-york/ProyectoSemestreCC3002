package model.items

import model.items.Potions.ManaPotion
import munit.FunSuite

class PotionTest extends FunSuite{
  private var potion1: ManaPotion = _
  private val name = "potion"

  override def beforeEach(context: BeforeEach): Unit = {
    potion1 = new ManaPotion(name)
  }

  test("A potion has a name.") {
    assertEquals(potion1.getName, "potion")
  }
}
