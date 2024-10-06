package model.actions

// Trait defining basic actions with a name
trait IAction {
  def setName(name: String): Unit // Sets the action's name
  
  def getName: String // Retrieves the action's name
}
