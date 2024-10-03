package model.units

import model.items.Potions.ManaPotion
import model.items.Weapons.Sword
import munit.FunSuite
import model.items.{Item, Weapon}
import model.units.Characters.*


class CharacterTest extends FunSuite{
  //all normal characters extend from the same abstract, without new functions, so test will be applied to only one type of normal characters
  private var knight1: Knight = _
  private var blackWizard1: BlackWizard = _
  private var whiteWizard1: WhiteWizard = _
  private var thief1: Thief = _
  private var archer: Archer = _
  private val name = "character"
  private val healthPoints = 90
  private val defensePoints = 60
  private val weight = 30
  private val manaPoints = 30
  private val weapon = new Sword("weapon", 90, 30, knight1)
  private val item1 = new ManaPotion("potion")
  private val itemInventory: List[Item] = List(weapon, item1)

  override def beforeEach(context: BeforeEach): Unit = {
    knight1 = new Knight(name, healthPoints, defensePoints, weight, Some(weapon), itemInventory)
    thief1 = new Thief(name, healthPoints, defensePoints, weight, None, itemInventory)
    archer = new Archer(name, healthPoints, defensePoints, weight, Some(weapon), List())
    blackWizard1 = new BlackWizard(name, healthPoints, defensePoints, weight, None, itemInventory, manaPoints)
    whiteWizard1 = new WhiteWizard(name, healthPoints, defensePoints, weight, None, itemInventory, manaPoints)
  }

  test("A character has a name.") {
    assertEquals(knight1.getName, "character")
    assertEquals(blackWizard1.getName, "character")
    knight1.setName("the black knight")
    assertEquals(knight1.getName, "the black knight")
  }

  test("A character has health points.") {
    assertEquals(knight1.getHp, 90)
    assertEquals(blackWizard1.getHp, 90)
    blackWizard1.setHp(120)
    assertEquals(blackWizard1.getHp, 120)
  }

  test("A character has damage points.") {
    assertEquals(knight1.getDp, 60)
    assertEquals(blackWizard1.getDp, 60)
    knight1.setDp(90)
    assertEquals(knight1.getDp, 90)
  }

  test("A character has a certain weight.") {
    assertEquals(knight1.getWeight, 30)
    assertEquals(blackWizard1.getWeight, 30)
    knight1.setWeight(90)
    assertEquals(knight1.getWeight, 90)
  }

  test("A character has a weapon slot.") {
    assertEquals(knight1.getWeapon, Some(weapon))
    assertEquals(blackWizard1.getWeapon, None)
    knight1.setWeapon(None)
    assertEquals(knight1.getWeapon, None)
  }

  test("A character has an item inventory.") {
    assertEquals(knight1.getItemInventory, itemInventory)
    assertEquals(blackWizard1.getItemInventory, itemInventory)
    blackWizard1.setItemInventory(List())
    assertEquals(blackWizard1.getItemInventory, List())
  }

  test("A magical characters has mana points.") {
    assertEquals(blackWizard1.getMp, 30)
    blackWizard1.setMp(45)
    assertEquals(blackWizard1.getMp, 45)
  }

  test("A character can calculate the maximum for its action bar"){
    assertEquals(knight1.calculateActionBarMax, 45.0)
    assertEquals(blackWizard1.calculateActionBarMax, 30.0)
  }
}
