package model.units

import munit.FunSuite

class EnemyTest extends FunSuite {
  
  var enemy: Enemy = _

  override def beforeEach(context: BeforeEach): Unit = {
    enemy = new Enemy()

    enemy.setName("juan")
    enemy.setHp(90)
    enemy.setDp(60)
    enemy.setWeight(30)
    enemy.setAtk(40)
  }
  
  test("An enemy has a name.") {
    assertEquals(enemy.getName, "juan")
  }

  test("An enemy has health points.") {
    assertEquals(enemy.getHp, 90)
  }

  test("An enemy has damage points.") {
    assertEquals(enemy.getDp, 60)
  }

  test("An enemy has a certain weight.") {
    assertEquals(enemy.getWeight, 30)
  }

  test("An enemy has attack points.") {
    assertEquals(enemy.getAtk, 40)
  }  
}
