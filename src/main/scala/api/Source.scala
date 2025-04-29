package api

import model.actions.Action

trait Source extends GameObject {

  /** The name of the source. */
  val name: String

  /** The actions that the source can perform. */
  val actions: List[Action]

  /** Finds an action by its id. */
  def findActionById(id: String): Action

  /** Performs an action on a target. */
  def doAction(action: Action, target: Target): Unit
}
