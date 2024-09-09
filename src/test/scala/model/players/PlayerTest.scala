package model.players

import model.units.Enemy
import munit.FunSuite

class PlayerTest extends FunSuite {
  var player1: Player = _
  var player2: Player = _
  var enemy1: Enemy = _
  var enemy2: Enemy = _

  override def beforeEach(context: BeforeEach): Unit = {
    enemy1 = new Enemy()
    enemy1.setName("juan")
    enemy1.setHp(90)
    enemy1.setDp(60)
    enemy1.setWeight(30)
    enemy1.setAtk(40)
    
    enemy2 = new Enemy()
    enemy1.setName("john")
    enemy1.setHp(91)
    enemy1.setDp(61)
    enemy1.setWeight(31)
    enemy1.setAtk(41)
    
    player1 = new Player(List(), true)
    player2 = new Player(List(enemy1, enemy2), false)
  }

  test("A player has a list of units") {
    assertEquals(player1.getUnitList, List())
    assertEquals(player2.getUnitList, List(enemy1, enemy2))
  }

  test("A player can be defeated") {
    assertEquals(player1.isDefeated, true)
    assertEquals(player2.isDefeated, false)
  }
}
