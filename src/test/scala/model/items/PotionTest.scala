package model.items

import model.items.Potions.MagicPotions.*
import model.items.Potions.NormalPotions.*
import munit.FunSuite

class PotionTest extends FunSuite{
  private var mana1: ManaPotion = _
  private var magicForce1: MagicForcePotion = _
  private var strength1: StrengthPotion = _
  private var healing1: HealingPotion = _
  private val name = "potion"

  override def beforeEach(context: BeforeEach): Unit = {
    mana1 = new ManaPotion(name)
    magicForce1 = new MagicForcePotion(name)
    strength1 = new StrengthPotion(name)
    healing1 = new HealingPotion(name)
  }

  test("A potion has a name.") {
    assertEquals(mana1.getName, "potion")
  }
}
