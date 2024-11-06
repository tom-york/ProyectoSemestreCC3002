package model.units

import model.actions.base.{Attack, Move}
import model.actions.spells.black.Thunder
import model.actions.usage.Consume
import model.items.potions.magic.{MagicForcePotion, ManaPotion}
import model.items.potions.normal.{HealingPotion, StrengthPotion}
import model.items.weapons.magic.Wand
import model.items.weapons.normal.Sword
import model.panels.Panel
import model.units.characters.magic.BlackWizard
import model.units.characters.normal.Knight
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class DoActionTest extends FunSuite{
  private var knight1: Knight = _
  private var blackWizard1: BlackWizard = _
  private var weapon1: Sword = _
  private var weapon2: Wand = _
  private var enemy1: Enemy = _
  private val mana1: ManaPotion = new ManaPotion("Mana Potion")
  private val magicForce1: MagicForcePotion = new MagicForcePotion("Magic Force Potion")
  private val strength1: StrengthPotion = new StrengthPotion("Strength Potion")
  private val healing1: HealingPotion = new HealingPotion("Healing Potion")
  private var panel1: Panel = _
  private var panel2: Panel = _
  private var panel3: Panel = _
  private val name = "character"
  private val healthPoints = 90
  private val defensePoints = 60
  private val weight = 30
  private val manaPoints = 30

  override def beforeEach(context: BeforeEach): Unit = {
    panel1 = new Panel((1,1), ArrayBuffer())
    panel2 = new Panel((1,2), ArrayBuffer())
    panel3 = new Panel((3,3), ArrayBuffer())
    panel1.setSouth(Some(panel2))
    panel2.setNorth(Some(panel1))
    knight1 = new Knight(name, healthPoints, defensePoints, weight, panel1, List())
    blackWizard1 = new BlackWizard(name, healthPoints, defensePoints, weight, panel1, List(), manaPoints)
    weapon1 = new Sword("weapon", 90, 30)
    weapon1.setOwner(knight1)
    weapon2 = new Wand("wand", 30, 30, 30)
    weapon2.setOwner(blackWizard1)
    enemy1 = new Enemy("juan", 90, 50, 30, panel1, 80)
  }

  test("Attack a unit.") {
    knight1.doAction(new Attack(), enemy1)
    assertEquals(enemy1.getHp, 50)

    enemy1.doAction(new Attack(), blackWizard1)
    assertEquals(blackWizard1.getHp, 70)

    blackWizard1.doAction(new Attack(), knight1)
    assertEquals(knight1.getHp, 90)
  }

  test("Move a unit.") {
    knight1.doAction(new Move(), panel2)
    assertEquals(panel2.getUnits, ArrayBuffer(knight1))
    enemy1.doAction(new Move(), panel2)
    assertEquals(panel2.getUnits, ArrayBuffer(knight1, enemy1))
    blackWizard1.doAction(new Move(), panel2)
    assertEquals(panel2.getUnits, ArrayBuffer(knight1, enemy1, blackWizard1))
    assertEquals(knight1.getPanel, panel2)
    assertEquals(enemy1.getPanel, panel2)
    assertEquals(blackWizard1.getPanel, panel2)
  }

  test("Consume a healing potion.") {
    //test healing potion
    knight1.setHp(10)
    knight1.doAction(new Consume("Healing", List(healing1)), healing1)
    assertEquals(knight1.getHp, 28)
    //check no over-healing occurs
    blackWizard1.setHp(80)
    blackWizard1.doAction(new Consume("Healing", List(healing1)), healing1)
    assertEquals(blackWizard1.getHp, 90)
  }

  test("Consume a strength potion.") {
    //test strength potion
    knight1.doAction(new Consume("Strength", List(strength1)), strength1)
    assertEquals(knight1.getDp, 69)
    blackWizard1.doAction(new Consume("Strength", List(strength1)), strength1)
    assertEquals(blackWizard1.getDp, 69)
  }

  test("Consume a Magic Force potion.") {
    //test magic force potion
    blackWizard1.doAction(new Consume("Magic Force", List(magicForce1)), magicForce1)
    assertEquals(blackWizard1.getMagicDamage, 45)
    //check if it resets after using a spell
    blackWizard1.doAction(new Thunder(), enemy1)
    assertEquals(blackWizard1.getMagicDamage, 30)
  }

  test("Consume a Mana potion.") {
    //test mana potion
    blackWizard1.setMp(10)
    blackWizard1.doAction(new Consume("Mana", List(mana1)), mana1)
    assertEquals(blackWizard1.getMp, 19)
    //check mana points aren't over the maximum
    blackWizard1.setMp(22)
    blackWizard1.doAction(new Consume("Mana", List(mana1)), mana1)
    assertEquals(blackWizard1.getMp, 30)
  }
}
