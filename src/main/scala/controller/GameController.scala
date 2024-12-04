package controller

import api.{GameApi, IGameController, Source}
import model.actions.Action
import model.exceptions.NoIdFound
import model.panels.Panel
import model.patterns.observer.{ISubject, Observer}
import model.players.Player
import model.scheduler.TaskScheduler
import model.units.Units
import util.Json.{*, given}

import scala.collection.mutable.ArrayBuffer

object GameController extends IGameController with Observer[Boolean] {
  /* write your code here */

  private var gameScheduler: TaskScheduler = _
  val playerList: ArrayBuffer[Player] = ArrayBuffer()
  private var isFinished: Boolean = false
  private val panel1: Panel = new Panel((1, 1), ArrayBuffer())
  private val panel2: Panel = new Panel((1, 2), ArrayBuffer())
  private val panel3: Panel = new Panel((2, 1), ArrayBuffer())
  private val panel4: Panel = new Panel((2, 2), ArrayBuffer())
  panel1.setSouth(Some(panel3))
  panel1.setEast(Some(panel2))
  panel2.setWest(Some(panel1))
  panel2.setSouth(Some(panel4))
  panel3.setNorth(Some(panel1))
  panel3.setEast(Some(panel4))
  panel4.setNorth(Some(panel2))
  panel4.setWest(Some(panel3))

  /** Initializes the game by setting up the game scheduler and players.
   *
   * Creates two players, places them on specific panels, and adds their units
   * to the game scheduler.
   */
  def init(): Unit = {
    gameScheduler = new TaskScheduler()
    playerList.clear()
    val playersToAdd = Seq(new Player(), new Player())
    playersToAdd.foreach(addPlayers)
    playerList(0).init(panel1)
    playerList(0).getUnitList.foreach(gameScheduler.addUnit(_))
    playerList(1).init(panel4)
    playerList(1).getUnitList.foreach(gameScheduler.addUnit(_))
  }

  /** Adds a player to the game and registers them as an observer.
   *
   * @param player The player to be added to the game
   */
  private def addPlayers(player: Player): Unit = {
    player.registerObserver(this)
    playerList += player
  }

  /** Updates the game's finish state when notified by an observed subject.
   *
   * @param o The subject sending the update
   * @param arg Boolean indicating if the game is finished
   */
  override def update(o: ISubject[Boolean], arg: Boolean): Unit = {
    if (arg) {
      isFinished = true
    }
  }

  /** Retrieves the current game state's completion status.
   *
   * @return Boolean indicating whether the game has finished
   */
  def getFinishState: Boolean = isFinished

  /** Returns the players of the game. In this version of the project, there are
   * strictly two players. Each player should send the information of his game
   * units.
   */
  def getPlayers: JsVal = {
    JsArr(
      playerList.map(p => p.toJson)
    )
  }

  /** Returns the game panels. These panels are basically the map where the game
   * units will be interacting with.
   */
  def getGamePanels: JsVal = {
    JsArr(
      panel1.toJson,
      panel2.toJson,
      panel3.toJson,
      panel4.toJson
    )
  }

  /** Returns the id of the current game unit. The current game unit is the unit
   * that can do actions, in other words, it's their turn.
   */

  def getCurrentGameUnitId: String = gameScheduler.getCurrentUnit.id

  /** Decides the next game unit id. This method is called after an action is
   * executed. It should return the id of the next game unit that will play.
   */
  def decideNextGameUnitId: String = {
    while (gameScheduler.getCompleteActionBarUnits.isEmpty) {
      gameScheduler.increaseActionBars(1)
    }
    gameScheduler.getCompleteActionBarUnits.head.id
  }

  /** Returns the actions that a character can do. It receives the id of the
   * character and returns the actions that the character can do.
   *
   * @param id
   * the id of the game unit
   * @return
   * the actions that the game unit can do, or None if the game unit is not
   * found
   */
  def getUnitById(id: String): Units = {
    val gameUnits: List[Units] = gameScheduler.getSchedulerContent.keys.toList
    gameUnits.find(_.getId == id).getOrElse(
      throw new NoIdFound(id)
    )
  }
  
  /** Retrieves possible actions for a specific game unit.
   *
   * @param id Unique identifier of the game unit
   * @return Optional JSON array of available actions
   */
  def findActionsByGameUnitId(id: String): Option[JsVal] = {
    val gameUnit: Units = getUnitById(id)
    val actionsJson = JsArr(gameUnit.actions.map(_.toJson))

    Some(actionsJson)
  }

  /** Executes an action.
   *
   * @param actionId
   * the id of the action to execute
   * @param sourceId
   * the id of the game unit that is executing the action
   * @param targetId
   * the id of the game unit that is the target of the action
   * @return
   * a message that describes the result of the action
   */
  def doAction(actionId: String, sourceId: String, targetId: String): String = {
    if (!isFinished) {
      try {
        val source: Units = getUnitById(sourceId)
        val action: Action = source.findActionById(actionId)
        val target: Units = getUnitById(targetId)
        source.doAction(action, target)
        if (isFinished) "Game Finished"
        else "Action successful"
      } catch {
        case e: Exception => "Error"
      }
    }
    else "Game already finished"
  }

  /** Resets the game. All configurations and parameters should be reset too. */
  def reset(): Unit = {
    init()
    isFinished = false
  }

  def main(args: Array[String]): Unit = {

    init()
    GameApi.run(args)

  }
}
