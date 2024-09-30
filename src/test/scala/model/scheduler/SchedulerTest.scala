package model.scheduler

import model.items.Weapons.{Sword, Wand}
import model.units.Characters.{Knight, WhiteWizard}
import model.units.Enemy
import munit.FunSuite

class SchedulerTest extends FunSuite {
  private var scheduler1: TaskScheduler = _
  private val enemy1: Enemy = new Enemy("enemy1", 90, 30, 40, 50)
  private var character1: Knight = _
  private var weapon1: Sword = _
  private var character2: WhiteWizard = _
  private var weapon2: Wand = _

  override def beforeEach(context: BeforeEach): Unit = {
    character1 = new Knight("knight", 80, 40, 35, Some(weapon1), List())
    weapon1 = new Sword("sword", 40, 10, character1)
    character2 = new WhiteWizard("w wizard", 85, 30, 35, Some(weapon2), List(), 20)
    weapon2 = new Wand("sword", 30, 5, character1, 15)
    scheduler1 = new TaskScheduler()
    scheduler1.addUnit(enemy1)
    scheduler1.addUnit(character1)
  }

  test("A scheduler should be able to add and remove units.") {
    scheduler1.addUnit(character2)
    assertEquals(scheduler1.getSchedulerContent().size, 3)

    scheduler1.removeUnit(character1)
    assertEquals(scheduler1.getSchedulerContent().size, 2)
  }

  test("A scheduler must be capable of calculating the maximum for an action bar for all units.") {
    scheduler1.calculateActionBarMax()
    assertEquals(scheduler1.getSchedulerContent()(character1), 35 + 0.5*10)
    assertEquals(scheduler1.getSchedulerContent()(enemy1), 40)
  }

  test("A scheduler must be capable of keeping track of the action bar for all units in the battle.") {
    assertEquals(scheduler1.getSchedulerContent()(character1)(1), 0)
    assertEquals(scheduler1.getSchedulerContent()(enemy1)(1), 40)
      ... //arreglar despues
  }
  
}
