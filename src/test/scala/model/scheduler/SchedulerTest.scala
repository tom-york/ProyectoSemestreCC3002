package model.scheduler

import model.items.weapons.magic.Wand
import model.items.weapons.normal.Sword
import model.panels.Panel
import model.units.characters.magic.WhiteWizard
import model.units.characters.normal.Knight
import model.units.Enemy
import util.Json.{*, given}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class SchedulerTest extends FunSuite {
  private var panel1: Panel = _
  private var scheduler1: TaskScheduler = _
  private var enemy1: Enemy = _
  //max action bar should be 45
  private var character1: Knight = _
  private var weapon1: Sword = _
  private var character2: WhiteWizard = _
  private var weapon2: Wand = _

  override def beforeEach(context: BeforeEach): Unit = {
    panel1 = new Panel((1, 1), ArrayBuffer())
    enemy1 = new Enemy("enemy1", 90, 30, 45, panel1, 50)
    character1 = new Knight("knight", 80, 40, 35, panel1, List())
    weapon1 = new Sword("sword", 40, 10)
    weapon1.setOwner(character1)
    //max action bar should be 35 + 0.5*10 = 40
    character2 = new WhiteWizard("w wizard", 85, 30, 35, panel1, List(), 20)
    weapon2 = new Wand("sword", 30, 5, 15)
    weapon2.setOwner(character2)
    scheduler1 = new TaskScheduler()
    scheduler1.addUnit(enemy1)
    scheduler1.addUnit(character1)
  }

  test("A scheduler should be able to add and remove units.") {
    scheduler1.addUnit(character2)
    assertEquals(scheduler1.getSchedulerContent.size, 3)

    scheduler1.removeUnit(character1)
    assertEquals(scheduler1.getSchedulerContent.size, 2)
  }

  test("A scheduler must be capable of calculating the maximum for an action bar for all units.") {
    scheduler1.calculateActionBarMax()
    assertEquals(scheduler1.getSchedulerContent(character1).getMax, 35 + 0.5*10)
    assertEquals(scheduler1.getSchedulerContent(enemy1).getMax, 45.0)
  }

  test("A scheduler must be capable of increasing the action bar for all units in a certain amount.") {
    scheduler1.calculateActionBarMax()
    assertEquals(scheduler1.getSchedulerContent(character1).getCurrent, 0.0)
    assertEquals(scheduler1.getSchedulerContent(enemy1).getCurrent, 0.0)
    scheduler1.increaseActionBars(40)
    assertEquals(scheduler1.getSchedulerContent(character1).getCurrent, 40.0)
    assertEquals(scheduler1.getSchedulerContent(enemy1).getCurrent, 40.0)
  }
  
  test("A scheduler must be capable of keeping track of the action bar for all units in the battle.") {
    assertEquals(scheduler1.getSchedulerContent(character1).getTuple, (0.0,0.0))
    assertEquals(scheduler1.getSchedulerContent(enemy1).getTuple, (0.0,0.0))
    scheduler1.calculateActionBarMax()
    scheduler1.increaseActionBars(20)
    assertEquals(scheduler1.getSchedulerContent(character1).getTuple, (40.0,20.0))
    assertEquals(scheduler1.getSchedulerContent(enemy1).getTuple, (45.0,20.0))
  }
  
  test("A scheduler must be capable of resetting the action bar of a units.") {
    scheduler1.calculateActionBarMax()
    scheduler1.increaseActionBars(35)
    assertEquals(scheduler1.getSchedulerContent(character1).getCurrent, 35.0)
    scheduler1.restartActionBar(character1)
    assertEquals(scheduler1.getSchedulerContent(character1).getCurrent, 0.0)
  }
  
  test("A scheduler should be able to indicate if a unit has completed its action bar.") {
    scheduler1.calculateActionBarMax()
    assertEquals(scheduler1.isActionBarComplete(character1), false)
    assertEquals(scheduler1.isActionBarComplete(enemy1), false)
    scheduler1.increaseActionBars(40)
    assertEquals(scheduler1.isActionBarComplete(character1), true)
    assertEquals(scheduler1.isActionBarComplete(enemy1), false)
  }

  test("A scheduler should be able to return all units that have completed their action bars in order.") {
    scheduler1.calculateActionBarMax()
    assertEquals(scheduler1.getCompleteActionBarUnits, ArrayBuffer())
    scheduler1.increaseActionBars(45)
    assertEquals(scheduler1.getCompleteActionBarUnits, ArrayBuffer(character1, enemy1))
  }

  test("A scheduler should be able to return all units that have completed their action bars in order.") {
    scheduler1.calculateActionBarMax()
    scheduler1.increaseActionBars(45)
    assertEquals(scheduler1.getCurrentUnit, character1)
  }
}
