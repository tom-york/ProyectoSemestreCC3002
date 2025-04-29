package model.actions

/** Abstract class implementing Action, providing basic action behavior.
 *
 * Defines methods for setting and retrieving the action's name.
 *
 * @param actionName The name of the action.
 */
abstract class AbstractAction(private var actionName: String) extends Action {

  /** Sets the action's name.
   *
   * @param name The new name for the action.
   */
  def setName(name: String): Unit = {
    actionName = name
  }

  /** @return The current name of the action. */
  def getName: String = actionName

  /** @return The unique identifier for this action. */
  def getId: String = this.id
}