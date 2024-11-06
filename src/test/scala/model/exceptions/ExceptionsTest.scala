package model.exceptions

import model.actions.base.{Attack, Move}
import model.actions.spells.black.{Meteorite, Thunder}
import model.actions.spells.white.{Heal, Purify}
import model.actions.usage.{Consume, Equip}
import model.items.potions.magic.{MagicForcePotion, ManaPotion}
import model.items.potions.normal.{HealingPotion, StrengthPotion}
import model.items.weapons.magic.{Staff, Wand}
import model.items.weapons.normal.{Bow, Dagger, Sword}
import model.panels.Panel
import model.units.Enemy
import model.units.characters.magic.{BlackWizard, WhiteWizard}
import model.units.characters.normal.{Archer, Knight, Thief}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class ExceptionsTest extends FunSuite {
  def assertException[T <: Exception](body: => Unit): Unit = {
    try {
      body
      assert(false)
    } catch {
      case e: T => assert(true)
    }
  }

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
    panel1 = new Panel((1, 1), ArrayBuffer())
    panel2 = new Panel((1, 2), ArrayBuffer())
    panel3 = new Panel((3, 3), ArrayBuffer())
    panel1.setSouth(Some(panel2))
    panel2.setNorth(Some(panel1))
    knight1 = new Knight(name, healthPoints, defensePoints, weight, panel1, List())
    archer1 = new Archer(name, healthPoints, defensePoints, weight, panel1, List())
    thief1 = new Thief(name, healthPoints, defensePoints, weight, panel1, List())
    whiteWizard1 = new WhiteWizard(name, healthPoints, defensePoints, weight, panel1, List(), manaPoints)
    blackWizard1 = new BlackWizard(name, healthPoints, defensePoints, weight, panel1, List(), manaPoints)
    sword = new Sword("weapon", 90, 30)
    sword.setOwner(knight1)
    wand = new Wand("wand", 30, 30, 40)
    wand.setOwner(blackWizard1)
    enemy1 = new Enemy("juan", 90, 20, 30, panel1, 80)
  }
  //Exception for executing a spell with insufficient mana points
  test("Applying a spell without enough mana points.") {
    blackWizard1.setMp(49)
    assertException[InsufficientManaPoints](blackWizard1.doAction(Meteorite(), panel1))
    blackWizard1.setMp(19)
    assertException[InsufficientManaPoints](blackWizard1.doAction(Thunder(), enemy1))
    wand.setOwner(whiteWizard1)
    whiteWizard1.setMp(14)
    assertException[InsufficientManaPoints](whiteWizard1.doAction(Heal(), blackWizard1))
    assertException[InsufficientManaPoints](whiteWizard1.doAction(Purify(), enemy1))
  }
  //Exception for executing an action with insufficient health points
  test("Applying an action without enough health points.") {
    blackWizard1.setHp(0)
    knight1.setHp(0)
    enemy1.setHp(0)
    assertException[InsufficientHP](blackWizard1.doAction(Attack(), enemy1))
    assertException[InsufficientHP](knight1.doAction(Attack(), enemy1))
    assertException[InsufficientHP](enemy1.doAction(Attack(), enemy1))
  }
  //Exception for applying an action over a defeated unit
  test("Applying an action over a defeated unit.") {
    whiteWizard1.setHp(0)
    knight1.setHp(0)
    enemy1.setHp(0)
    assertException[DefeatedTarget](blackWizard1.doAction(Thunder(), whiteWizard1))
    assertException[DefeatedTarget](blackWizard1.doAction(Heal(), knight1))
    assertException[DefeatedTarget](blackWizard1.doAction(Purify(), enemy1))
  }
  //Exception for trying to equip an incompatible weapon
  test("Equip an incompatible weapon for the type of character.") {
    //Incompatible weapons for a knight
    assertException[IncompatibleWeapon](knight1.doAction(Equip("Equip", List()), wand))
    assertException[IncompatibleWeapon](knight1.doAction(Equip("Equip", List()), new Staff()))
    //Incompatible weapons for a white wizard
    assertException[IncompatibleWeapon](whiteWizard1.doAction(Equip("Equip", List()), sword))
    assertException[IncompatibleWeapon](whiteWizard1.doAction(Equip("Equip", List()), new Dagger()))
    //Incompatible weapons for a black wizard
    assertException[IncompatibleWeapon](blackWizard1.doAction(Equip("Equip", List()), sword))
    assertException[IncompatibleWeapon](blackWizard1.doAction(Equip("Equip", List()), new Bow()))
    //Incompatible weapons for an archer
    assertException[IncompatibleWeapon](archer1.doAction(Equip("Equip", List()), new Dagger()))
    assertException[IncompatibleWeapon](archer1.doAction(Equip("Equip", List()), new Staff()))
    //Incompatible weapons for a thief
    assertException[IncompatibleWeapon](thief1.doAction(Equip("Equip", List()), new Staff()))
    assertException[IncompatibleWeapon](thief1.doAction(Equip("Equip", List()), new Wand()))
    assertException[IncompatibleWeapon](thief1.doAction(Equip("Equip", List()), new Bow()))
  }
  //Exception for trying to attack without a weapon
  test("Applying an action over a defeated unit.") {
    assertException[WeaponNotPresent](whiteWizard1.doAction(Attack(), whiteWizard1))
  }
  //Exception for trying to move to a not adjacent panel
  test("Trying to move to an non-neighboring panel.") {
    assertException[NotAdjacentPanel](enemy1.doAction(Move(), panel3))
  }
  //Exception for trying to cast a spell with a non-magic weapon
  test("Trying to cast a spell with a normal weapon.") {
    val bow: Bow = new Bow()
    bow.setOwner(whiteWizard1)
    assertException[MagicWeaponNotPresent](whiteWizard1.doAction(Thunder(), enemy1))
  }
  //Exception for trying to use the purify spell on characters
  test("Trying to cast the purify spell on a character.") {
    wand.setOwner(whiteWizard1)
    assertException[InvalidActionTarget](whiteWizard1.doAction(Purify(), knight1))
  }
  //Exception for trying to use the heal spell on enemies
  test("Trying to cast the heal spell on an enemy.") {
    wand.setOwner(whiteWizard1)
    assertException[InvalidActionTarget](whiteWizard1.doAction(Heal(), enemy1))
  }
  //Exception for trying to find an unavailable action on a unit
  test("Trying to fetch an unavailable action by its id") {
    assertException[NoIdFound](enemy1.findActionById("8"))
  }
  //Exception for trying to set health points or mana points out of the limits
  test("Trying to set points over the maximum or under zero.") {
    assertException[IllegalArgumentException](enemy1.setHp(1000))
    assertException[IllegalArgumentException](enemy1.setHp(-1000))
    assertException[IllegalArgumentException](blackWizard1.setMp(1000))
    assertException[IllegalArgumentException](blackWizard1.setMp(-1000))
  }
}

