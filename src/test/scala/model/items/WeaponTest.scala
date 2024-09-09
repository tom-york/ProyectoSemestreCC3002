package model.items

import munit.FunSuite
import model.units.Knight

class WeaponTest {
  private val sword1: Sword = new Sword()
  private val wand1: Wand = new Wand()
  private val name = "weapon"
  private val attackPoints = 90
  private val weight = 30
  private val magicAttackPoints = 30
  private val owner1: Knight = Knight()

  override def beforeEach(context: BeforeEach): Unit = {
    sword1.setName(name)
    sword1.setAttackPoints(attackPoints)
    sword1.setWeight(weight)
    sword1.setOwner(owner1)

    wand1.setName(name)
    wand1.setAttackPoints(attackPoints)
    wand1.setWeight(weight)
    wand1.setOwner(owner1)
    wand1.setMagicAttackPoints(magicAttackPoints)  
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
    assertEquals(sword1.getOwner, 30)
    assertEquals(wand1.getOwner, 30)
  }

  test("A magical weapon has magic attack points.") {
    assertEquals(wand1.getMagicAttackPoints, 30)
  }
  
}
