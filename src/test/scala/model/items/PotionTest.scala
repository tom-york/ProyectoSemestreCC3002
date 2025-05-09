package model.items

import model.items.potions.magic.*
import model.items.potions.normal.*
import munit.FunSuite
import util.Json.{*, given}

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
    mana1.setName("mana potion")
    assertEquals(mana1.getName, "mana potion")
  }

  test("Potion JSON test") {
    val manaJson = JsObj(
      "id" -> mana1.id,
      "name" -> "potion"
    )
    val magicForceJson = JsObj(
      "id" -> magicForce1.id,
      "name" -> "potion"
    )
    val strengthJson = JsObj(
      "id" -> strength1.id,
      "name" -> "potion"
    )
    val healingJson = JsObj(
      "id" -> healing1.id,
      "name" -> "potion"
    )
    assertEquals(mana1.toJson, manaJson)
    assertEquals(magicForce1.toJson, magicForceJson)
    assertEquals(strength1.toJson, strengthJson)
    assertEquals(healing1.toJson, healingJson)
  }
}
