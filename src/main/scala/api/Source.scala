package api

trait Source extends GameObject {

  /** The name of the source. */
  val name: String

  /** The actions that the source can perform. */
  val actions: List[???]

  /** Finds an action by its id. */
  def findActionById(id: String): ???

  /** Performs an action on a target. */
  def doAction(action: ???, target: Target): Unit
}
