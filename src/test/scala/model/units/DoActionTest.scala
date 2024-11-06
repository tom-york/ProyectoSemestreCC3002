package model.units

import model.actions.base.{Attack, Move}
import model.items.potions.magic.ManaPotion
import model.items.potions.normal.StrengthPotion
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
  private var mana1: ManaPotion = _
  private var strength1: StrengthPotion = _
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
    assertEquals(knight1.getPanel, panel1)
    assertEquals(enemy1.getPanel, panel1)
    assertEquals(blackWizard1.getPanel, panel1)
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
}
