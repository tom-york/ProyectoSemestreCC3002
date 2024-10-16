package model.actions

import model.actions.Base.*
import model.actions.Spells.BlackMagic
import model.actions.Spells.BlackMagic.*
import model.actions.Spells.WhiteMagic.*
import model.actions.Usage.*
import model.items.Potions.MagicPotions.ManaPotion
import model.items.Weapons.NormalWeapons.Bow
import model.units.Characters.NormalCharacters.Knight
import munit.FunSuite
import util.Json.{*, given}

class ActionTest extends FunSuite{
  private val potion1: ManaPotion = new ManaPotion("Potion")
  private val weapon1: Bow = new Bow("weapon", 90, 30, new Knight("lolo", 30, 30, 30, None, List()))
  private var equip: Equip = _
  private var consume: Consume = _
  private var attack: Attack = _
  private var move: Move = _
  private var meteorite: Meteorite = _
  private var thunder: Thunder = _
  private var heal: Heal = _
  private var purify: Purify = _

  override def beforeEach(context: BeforeEach): Unit = {
    equip = new Equip("eq", List(weapon1))
    consume = new Consume("co", List(potion1))
    attack = new Attack("at")
    move = new Move("mv")
    meteorite = new Meteorite("mt")
    thunder = new Thunder("th")
    heal = new Heal("he")
    purify = new Purify("pu")
  }

  test("An action has a name.") {
    assertEquals(consume.getName, "co")
    consume.setName("consume")
    assertEquals(consume.getName, "consume")
    
    
  }

  test("An action that uses items has to have a list of the objects that it can use.") {
    assertEquals(equip.getUsableList, List(weapon1))
    equip.setUsableList(List())
    assertEquals(equip.getUsableList, List())

  }

  test("AbstractAction JSON test") {
    val moveJson = JsObj(
      "id" -> "Move",
      "action" -> "base→move"
    )
    val attackJson = JsObj(
      "id" -> "Attack",
      "action" -> "base→attack"
    )
    val equipJson = JsObj(
      "id" -> "Equip",
      "action" -> "usage→equip",
      "targets" -> JsArr(weapon1.toJson)
    )
    val consumeJson = JsObj(
      "id" -> "Consume",
      "action" -> "usage→consume",
      "targets" -> JsArr(potion1.toJson)
    )
    val meteoriteJson = JsObj(
      "id" -> "Meteorite",
      "action" -> "spell→blackMagic→meteorite"
    )
    val thunderJson = JsObj(
      "id" -> "Thunder",
      "action" -> "spell→blackMagic→thunder"
    )
    val healJson = JsObj(
      "id" -> "Heal",
      "action" -> "spell→whiteMagic→heal"
    )
    val purifyJson = JsObj(
      "id" -> "Purify",
      "action" -> "spell→whiteMagic→purify"
    )
    assertEquals(move.toJson, moveJson)
    assertEquals(attack.toJson, attackJson)
    assertEquals(equip.toJson, equipJson)
    assertEquals(consume.toJson, consumeJson)
    assertEquals(meteorite.toJson, meteoriteJson)
    assertEquals(thunder.toJson, thunderJson)
    assertEquals(heal.toJson, healJson)
    assertEquals(purify.toJson, purifyJson)
  }
}
