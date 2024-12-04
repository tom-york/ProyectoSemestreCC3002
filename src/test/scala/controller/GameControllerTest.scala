package controller

import model.items.weapons.magic.Wand
import model.items.weapons.normal.Sword
import model.panels.Panel
import model.players.Player
import model.scheduler.TaskScheduler
import model.units.Enemy
import model.units.characters.magic.WhiteWizard
import model.units.characters.normal.Knight
import munit.FunSuite
import util.Json.{*, given}

import scala.collection.mutable.ArrayBuffer

class GameControllerTest extends FunSuite {

  GameController.init()

  override def beforeEach(context: BeforeEach): Unit = {
    GameController.reset()
  }

  test("Game Finalization") {
    val players: ArrayBuffer[Player] = GameController.playerList
    val player1Units = players(0).getUnitList
    player1Units.foreach(_.setHp(0))
    assertEquals(GameController.getFinishState, true)
    assertEquals(GameController.doAction("1", player1Units.head.id, player1Units.last.id), "Game already finished")
  }
}
