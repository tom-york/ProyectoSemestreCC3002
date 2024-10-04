package model.items

import model.items.Weapons.MagicWeapons.*
import model.items.Weapons.NormalWeapons.*
import model.units.Characters.NormalCharacters.Knight
import munit.FunSuite

class WeaponTest extends FunSuite {
  private var sword1: Sword = _
  private var bow1: Bow = _
  private var dagger1: Dagger = _
  private var wand1: Wand = _
  private var staff1: Staff = _
  private val name = "weapon"
  private val attackPoints = 90
  private val weight = 30
  private val magicAttackPoints = 30
  private val owner1: Knight = Knight("juan", 90, 60, 30, None, List())

  override def beforeEach(context: BeforeEach): Unit = {
    sword1 = new Sword(name, attackPoints, weight, owner1)
    bow1 = new Bow(name, attackPoints, weight, owner1)
    dagger1 = new Dagger(name, attackPoints, weight, owner1)
    wand1 = new Wand(name, attackPoints, weight, owner1, magicAttackPoints)
    staff1 = new Staff(name, attackPoints, weight, owner1, magicAttackPoints)
  }

  test("A weapon has a name.") {
    assertEquals(sword1.getName, "weapon")
    assertEquals(wand1.getName, "weapon")
  }

  test("A weapon has attack points.") {
    assertEquals(sword1.getAttackPoints, 90)
    assertEquals(wand1.getAttackPoints, 90)
  }

  test("A weapon has a certain weight.") {
    assertEquals(sword1.getWeight, 30)
    assertEquals(wand1.getWeight, 30)
  }

  test("A weapon has an owner.") {
    assertEquals(sword1.getOwner, owner1)
    assertEquals(wand1.getOwner, owner1)
  }

  test("A magical weapon has magic attack points.") {
    assertEquals(wand1.getMagicAttackPoints, 30)
  }
  
}
