package model.actions

import model.actions.base.*
import model.actions.spells.black
import model.actions.spells.black.*
import model.actions.spells.white.*
import model.actions.usage.*
import model.items.potions.magic.ManaPotion
import model.items.weapons.normal.Bow
import model.panels.Panel
import model.units.characters.normal.Knight
import munit.FunSuite
import util.Json.{*, given}

import scala.collection.mutable.ArrayBuffer

class ActionTest extends FunSuite{
  private val potion1: ManaPotion = new ManaPotion("Potion")
  private var weapon1: Bow = _
  private var equip: Equip = _
  private var consume: Consume = _
  private var attack: Attack = _
  private var move: Move = _
  private var meteorite: Meteorite = _
  private var thunder: Thunder = _
  private var heal: Heal = _
  private var purify: Purify = _

  override def beforeEach(context: BeforeEach): Unit = {
    weapon1 = new Bow("weapon", 90, 30)
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
    val attackJson = JsObj(
      "id" -> "1",
      "action" -> "base→attack"
    )
    val moveJson = JsObj(
      "id" -> "2",
      "action" -> "base→move"
    )
    val meteoriteJson = JsObj(
      "id" -> "3",
      "action" -> "spell→black→meteorite"
    )
    val thunderJson = JsObj(
      "id" -> "4",
      "action" -> "spell→black→thunder"
    )
    val healJson = JsObj(
      "id" -> "5",
      "action" -> "spell→white→heal"
    )
    val purifyJson = JsObj(
      "id" -> "6",
      "action" -> "spell→white→purify"
    )
    val equipJson = JsObj(
      "id" -> "8",
      "action" -> "usage→equip",
      "targets" -> JsArr(weapon1.toJson)
    )
    val consumeJson = JsObj(
      "id" -> "7",
      "action" -> "usage→consume",
      "targets" -> JsArr(potion1.toJson)
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
