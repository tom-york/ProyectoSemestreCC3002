package model.items

import munit.FunSuite

class PotionTest extends FunSuite{
  private val potion1: ManaPotion = new ManaPotion()
  private val name = "potion"

  override def beforeEach(context: BeforeEach): Unit = {
    potion1.setName(name)
  }

  test("A potion has a name.") {
    assertEquals(potion1.getName, "potion")
  }
}
