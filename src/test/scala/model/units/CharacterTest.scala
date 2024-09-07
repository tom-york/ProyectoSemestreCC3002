package model.units

import model.items.{Item, Weapon}
import munit.FunSuite

class CharacterTest extends FunSuite{
  //all normal characters extend from the same abstract, without new functions, so test will be apply to only one type of normal characters
  private val knight1: Knight = new Knight()
  private val blackWizard1: BlackWizard = new BlackWizard()
  private val name = "character"
  private val healthPoints = 90
  private val defensePoints = 60
  private val weight = 30
  private val manaPoints = 30
  private val weapon = new Weapon()
  private val itemInventory: List[Item] =

  override def beforeEach(context: BeforeEach): Unit = {
    knight1.setName(name)
    knight1.setHp(healthPoints)
    knight1.setDp(defensePoints)
    knight1.setWeight(weight)
    knight1.setWeapon(weapon)
    knight1.setItemInventory(itemInventory)

    blackWizard1.setName(name)
    blackWizard1.setHp(healthPoints)
    blackWizard1.setDp(defensePoints)
    blackWizard1.setWeight(weight)
    blackWizard1.setWeapon(weapon)
    blackWizard1.setItemInventory(itemInventory)
    blackWizard1.setMp(manaPoints)
  }

  test("A character has a name.") {
    assertEquals(knight1.getName, "character")
    assertEquals(blackWizard1.getName, "character")
  }

  test("A character has health points.") {
    assertEquals(knight1.getHp, 90)
    assertEquals(blackWizard1.getHp, 90)
  }

  test("A character has damage points.") {
    assertEquals(knight1.getDp, 60)
    assertEquals(blackWizard1.getDp, 60)
  }

  test("A character has a certain weight.") {
    assertEquals(knight1.getWeight, 30)
    assertEquals(blackWizard1.getWeight, 30)
  }

  test("A character has a weapon slot.") {
    assertEquals(knight1.getWeapon, weapon)
    assertEquals(blackWizard1.getWeight, weapon)
  }

  test("A magical characters has mana points.") {
    assertEquals(blackWizard1.getMp, 30)
  }
}
