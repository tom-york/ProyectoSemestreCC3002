package model.scheduler

import model.items.Weapons.{Sword, Wand}
import model.units.Characters.{Knight, WhiteWizard}
import model.units.Enemy
import munit.FunSuite

class SchedulerTest extends FunSuite {
  private var scheduler1: TaskScheduler = _
  private val enemy1: Enemy = new Enemy("enemy1", 90, 30, 45, 50)
  //max action bar should be 45
  private var character1: Knight = _
  private var weapon1: Sword = _
  private var character2: WhiteWizard = _
  private var weapon2: Wand = _

  override def beforeEach(context: BeforeEach): Unit = {
    character1 = new Knight("knight", 80, 40, 35, Some(weapon1), List())
    weapon1 = new Sword("sword", 40, 10, character1)
    //max action bar should be 35 + 0.5*10 = 40
    character2 = new WhiteWizard("w wizard", 85, 30, 35, Some(weapon2), List(), 20)
    weapon2 = new Wand("sword", 30, 5, character1, 15)
    scheduler1 = new TaskScheduler()
    scheduler1.addUnit(enemy1)
    scheduler1.addUnit(character1)
  }

  test("A scheduler should be able to add and remove units.") {
    scheduler1.addUnit(character2)
    assertEquals(scheduler1.getSchedulerContent().size, te3)

    scheduler1.removeUnit(character1)
    assertEquals(scheduler1.getSchedulerContent().size, 2)
  }

  test("A scheduler must be capable of calculating the maximum for an action bar for all units.") {
    scheduler1.calculateActionBarMax()
    assertEquals(scheduler1.getSchedulerContent()(character1)(0), 35 + 0.5*10)
    assertEquals(scheduler1.getSchedulerContent()(enemy1)(0), 45)
  }

  test("A scheduler must be capable of increasing the action bar for all units in a certain amount.") {
    scheduler1.calculateActionBarMax()
    assertEquals(scheduler1.getSchedulerContent()(character1)(1), 0)
    assertEquals(scheduler1.getSchedulerContent()(enemy1)(1), 0)
    scheduler1.increaseActionBars(40)
    assertEquals(scheduler1.getSchedulerContent()(character1)(1), 40)
    assertEquals(scheduler1.getSchedulerContent()(enemy1)(1), 40)
  }
  
  test("A scheduler must be capable of keeping track of the action bar for all units in the battle.") {
    assertEquals(scheduler1.getSchedulerContent()(character1), (0,0))
    assertEquals(scheduler1.getSchedulerContent()(enemy1), (0,0))
    scheduler1.calculateActionBarMax()
    scheduler1.increaseActionBars(20)
    assertEquals(scheduler1.getSchedulerContent()(character1), (40,20))
    assertEquals(scheduler1.getSchedulerContent()(enemy1), (45,20))
  }
  
  test("A scheduler must be capable of resetting the action bar of a units.") {
    scheduler1.calculateActionBarMax()
    scheduler1.increaseActionBars(35)
    assertEquals(scheduler1.getSchedulerContent()(character1)(1), 35)
    scheduler1.restartActionBar(character1)
    assertEquals(scheduler1.getSchedulerContent()(character1)(1), 0)
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
    assertEquals(scheduler1.getCompleteActionBarUnits(), List())
    scheduler1.increaseActionBars(45)
    assertEquals(scheduler1.getCompleteActionBarUnits(), List(character1, enemy1))
  }

  test("A scheduler should be able to return all units that have completed their action bars in order.") {
    scheduler1.calculateActionBarMax()
    scheduler1.increaseActionBars(45)
    assertEquals(scheduler1.getCurrentUnit(), character1)
  }
}
