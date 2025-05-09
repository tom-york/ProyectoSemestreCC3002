package model.items

import model.items.weapons.magic.*
import model.items.weapons.normal.*
import model.panels.Panel
import model.units.characters.normal.Knight
import munit.FunSuite
import util.Json.{*, given}

import scala.collection.mutable.ArrayBuffer

class WeaponTest extends FunSuite {
  private val panel1: Panel = new Panel((1, 1), ArrayBuffer())
  private var sword1: Sword = _
  private var bow1: Bow = _
  private var dagger1: Dagger = _
  private var wand1: Wand = _
  private var staff1: Staff = _
  private val name = "weapon"
  private val attackPoints = 90
  private val weight = 30
  private val magicAttackPoints = 30
  private val owner1: Knight = Knight("juan", 90, 60, 30, panel1, ArrayBuffer())

  override def beforeEach(context: BeforeEach): Unit = {
    sword1 = new Sword(name, attackPoints, weight)
    bow1 = new Bow(name, attackPoints, weight)
    dagger1 = new Dagger(name, attackPoints, weight)
    wand1 = new Wand(name, attackPoints, weight, magicAttackPoints)
    staff1 = new Staff(name, attackPoints, weight, magicAttackPoints)
  }

  test("A weapon has a name.") {
    assertEquals(sword1.getName, "weapon")
    assertEquals(wand1.getName, "weapon")
    sword1.setName("master sword")
    assertEquals(sword1.getName, "master sword")
  }

  test("A weapon has attack points.") {
    assertEquals(sword1.getAttackPoints, 90)
    assertEquals(wand1.getAttackPoints, 90)
    wand1.setAttackPoints(120)
    assertEquals(wand1.getAttackPoints, 120)
  }

  test("A weapon has a certain weight.") {
    assertEquals(sword1.getWeight, 30)
    assertEquals(wand1.getWeight, 30)
    sword1.setWeight(100)
    assertEquals(sword1.getWeight, 100)
  }

  test("A weapon has an owner.") {
    assertEquals(sword1.getOwner, None)
    dagger1.setOwner(owner1)
    assertEquals(dagger1.getOwner, Some(owner1))
    val owner2: Knight = new Knight("kn", 90, 90, 90, panel1, ArrayBuffer())
    dagger1.setOwner(owner2)
    assertEquals(dagger1.getOwner, Some(owner2))
  }

  test("A magical weapon has magic attack points.") {
    assertEquals(wand1.getMagicAttackPoints, 30)
    assertEquals(staff1.getMagicAttackPoints, 30)
    staff1.setMagicAttackPoints(40)
    assertEquals(staff1.getMagicAttackPoints, 40)
  }

  test("Weapon JSON test") {
    val swordJson = JsObj(
      "id" -> sword1.id,
      "name" -> "weapon"
    )
    val bowJson = JsObj(
      "id" -> bow1.id,
      "name" -> "weapon"
    )
    val daggerJson = JsObj(
      "id" -> dagger1.id,
      "name" -> "weapon",
    )
    val wandJson = JsObj(
      "id" -> wand1.id,
      "name" -> "weapon",
    )
    val staffJson = JsObj(
      "id" -> staff1.id,
      "name" -> "weapon",
    )
    
    assertEquals(sword1.toJson, swordJson)
    assertEquals(bow1.toJson, bowJson)
    assertEquals(dagger1.toJson, daggerJson)
    assertEquals(wand1.toJson, wandJson)
    assertEquals(staff1.toJson, staffJson)
  }
}
