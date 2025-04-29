package model.units

import model.actions.base.{Attack, Move}
import model.actions.spells.black.{Meteorite, Thunder}
import model.actions.spells.white.{Heal, Purify}
import model.actions.usage.{Consume, Equip}
import model.items.potions.magic.{MagicForcePotion, ManaPotion}
import model.items.potions.normal.{HealingPotion, StrengthPotion}
import model.items.weapons.magic.{Staff, Wand}
import model.items.weapons.normal.{Bow, Dagger, Sword}
import model.panels.Panel
import model.units.characters.magic.{BlackWizard, WhiteWizard}
import model.units.characters.normal.{Archer, Knight, Thief}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class DoActionTest extends FunSuite{

  private var knight1: Knight = _
  private var archer1: Archer = _
  private var thief1: Thief = _
  private var blackWizard1: BlackWizard = _
  private var whiteWizard1: WhiteWizard = _
  private var sword: Sword = _
  private var wand: Wand = _
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
  private val defensePoints = 30
  private val weight = 30
  private val manaPoints = 50

  override def beforeEach(context: BeforeEach): Unit = {
    panel1 = new Panel((1,1), ArrayBuffer())
    panel2 = new Panel((1,2), ArrayBuffer())
    panel3 = new Panel((3,3), ArrayBuffer())
    panel1.setSouth(Some(panel2))
    panel2.setNorth(Some(panel1))
    knight1 = new Knight(name, healthPoints, defensePoints, weight, panel1, ArrayBuffer())
    archer1 = new Archer(name, healthPoints, defensePoints, weight, panel1, ArrayBuffer())
    thief1 = new Thief(name, healthPoints, defensePoints, weight, panel1, ArrayBuffer())
    whiteWizard1 = new WhiteWizard(name, healthPoints, defensePoints, weight, panel1, ArrayBuffer(), manaPoints)
    blackWizard1 = new BlackWizard(name, healthPoints, defensePoints, weight, panel1, ArrayBuffer(), manaPoints)
    sword = new Sword("weapon", 90, 30)
    sword.setOwner(knight1)
    wand = new Wand("wand", 30, 30, 40)
    wand.setOwner(blackWizard1)
    enemy1 = new Enemy("juan", 90, 20, 30, panel1, 80)
  }

// Attack action tests
  test("Attack a unit.") {
    knight1.doAction(new Attack(), enemy1)
    assertEquals(enemy1.getHp, 20)

    enemy1.doAction(new Attack(), blackWizard1)
    assertEquals(blackWizard1.getHp, 40)

    blackWizard1.doAction(new Attack(), knight1)
    assertEquals(knight1.getHp, 90)
  }

// Move action tests
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

// Consume action tests
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
    assertEquals(knight1.getDp, 35)
    blackWizard1.doAction(new Consume("Strength", List(strength1)), strength1)
    assertEquals(blackWizard1.getDp, 35)
  }

  test("Consume a Magic Force potion.") {
    //test magic force potion
    blackWizard1.doAction(new Consume("Magic Force", List(magicForce1)), magicForce1)
    assertEquals(blackWizard1.getMagicDamage, 60)
    //check if it resets after using a spell
    blackWizard1.doAction(new Thunder(), enemy1)
    assertEquals(blackWizard1.getMagicDamage, 40)
  }

  test("Consume a Mana potion.") {
    //test mana potion
    blackWizard1.setMp(10)
    blackWizard1.doAction(new Consume("Mana", List(mana1)), mana1)
    assertEquals(blackWizard1.getMp, 25)
    //check mana points aren't over the maximum
    blackWizard1.setMp(45)
    blackWizard1.doAction(new Consume("Mana", List(mana1)), mana1)
    assertEquals(blackWizard1.getMp, 50)
  }
// Equip action tests
  test("Equip a sword") {
    //test equipping sword
    knight1.doAction(new Equip("Sword", List(sword)), sword)
    assertEquals(knight1.getWeapon, Some(sword))
    archer1.doAction(new Equip("Sword", List(sword)), sword)
    assertEquals(archer1.getWeapon, Some(sword))
    thief1.doAction(new Equip("Sword", List(sword)), sword)
    assertEquals(thief1.getWeapon, Some(sword))
    //check if old owners don't have the weapon anymore
    assertEquals(knight1.getWeapon, None)
    assertEquals(archer1.getWeapon, None)
  }
  test("Equip a dagger") {
    val dagger: Dagger = new Dagger("weapon", 90, 30)
    //test equipping sword
    knight1.doAction(new Equip("Dagger", List(dagger)), dagger)
    assertEquals(knight1.getWeapon, Some(dagger))
    blackWizard1.doAction(new Equip("Dagger", List(dagger)), dagger)
    assertEquals(blackWizard1.getWeapon, Some(dagger))
    thief1.doAction(new Equip("Dagger", List(dagger)), dagger)
    assertEquals(thief1.getWeapon, Some(dagger))
    //check if old owners don't have the weapon anymore
    assertEquals(knight1.getWeapon, None)
    assertEquals(blackWizard1.getWeapon, None)
  }
  test("Equip a Bow") {
    val bow: Bow = new Bow("weapon", 90, 30)
    //test equipping sword
    knight1.doAction(new Equip("Dagger", List(bow)), bow)
    assertEquals(knight1.getWeapon, Some(bow))
    archer1.doAction(new Equip("Dagger", List(bow)), bow)
    assertEquals(archer1.getWeapon, Some(bow))
    whiteWizard1.doAction(new Equip("Dagger", List(bow)), bow)
    assertEquals(whiteWizard1.getWeapon, Some(bow))
    //check if old owners don't have the weapon anymore
    assertEquals(knight1.getWeapon, None)
    assertEquals(archer1.getWeapon, None)
  }
  test("Equip a wand") {
    //test equipping sword
    blackWizard1.doAction(new Equip("Wand", List(wand)), wand)
    assertEquals(blackWizard1.getWeapon, Some(wand))
    archer1.doAction(new Equip("Wand", List(wand)), wand)
    assertEquals(archer1.getWeapon, Some(wand))
    whiteWizard1.doAction(new Equip("Wand", List(wand)), wand)
    assertEquals(whiteWizard1.getWeapon, Some(wand))
    //check if old owners don't have the weapon anymore
    assertEquals(blackWizard1.getWeapon, None)
    assertEquals(archer1.getWeapon, None)
  }
  test("Equip a staff") {
    val staff: Staff = new Staff("staff", 30, 30, 30)
    //test equipping sword
    blackWizard1.doAction(new Equip("Staff", List(staff)), staff)
    assertEquals(blackWizard1.getWeapon, Some(staff))
    whiteWizard1.doAction(new Equip("Staff", List(staff)), staff)
    assertEquals(whiteWizard1.getWeapon, Some(staff))
    //check if old owners don't have the weapon anymore
    assertEquals(blackWizard1.getWeapon, None)
  }
//Spell action test
  test("Heal a character") {
    //test healing a character
    knight1.setHp(20)
    wand.setOwner(whiteWizard1)
    whiteWizard1.doAction(new Heal(), knight1)
    assertEquals(knight1.getHp, 48)
    assertEquals(whiteWizard1.getMp, 35)
    //check no over-healing occurs
    knight1.setHp(80)
    whiteWizard1.doAction(new Heal(), knight1)
    assertEquals(knight1.getHp, 90)
    assertEquals(whiteWizard1.getMp, 20)
  }
  test("Purify an enemy") {
    //test purifying an enemy
    wand.setOwner(whiteWizard1)
    whiteWizard1.doAction(new Purify(), enemy1)
    assertEquals(enemy1.getHp, 76)
    assertEquals(whiteWizard1.getMp, 25)
    //check no negative health
    enemy1.setHp(8)
    whiteWizard1.doAction(new Purify(), enemy1)
    assertEquals(enemy1.getHp, 0)
    assertEquals(whiteWizard1.getMp, 0)
  }
  test("Use meteorite over a panel.") {
    //test use meteorite action over a panel with units.
    blackWizard1.doAction(new Meteorite(), panel1)
    assertEquals(enemy1.getHp, 70)
    assertEquals(knight1.getHp, 80)
    assertEquals(blackWizard1.getHp, 80)
    assertEquals(blackWizard1.getMp, 0)
    //check no negative health
    enemy1.setHp(10)
    knight1.setHp(5)
    blackWizard1.setHp(5)
    blackWizard1.setMp(50)
    blackWizard1.doAction(new Meteorite(), panel1)
    assertEquals(enemy1.getHp, 0)
    assertEquals(knight1.getHp, 0)
    assertEquals(blackWizard1.getHp, 0)
    assertEquals(blackWizard1.getMp, 0)
  }
  test("Use thunder over a unit.") {
    //test use thunder action over unit.
    blackWizard1.doAction(new Thunder(), enemy1)
    assertEquals(enemy1.getHp, 70)
    assertEquals(blackWizard1.getMp, 30)
    //check no negative health
    enemy1.setHp(10)
    blackWizard1.doAction(new Thunder(), enemy1)
    assertEquals(enemy1.getHp, 0)
    assertEquals(blackWizard1.getMp, 10)
  }
}
