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
}

