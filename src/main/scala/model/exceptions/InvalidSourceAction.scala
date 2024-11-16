package model.exceptions

/**
 * Exception thrown when an entity attempts to perform an action it's not authorized to execute.
 *
 * @param sourceName The name of the entity attempting to perform the action.
 * @param actionName The name of the action being attempted.
 * @throws InvalidSourceAction when an entity attempts to perform an action it cannot execute.
 */
class InvalidSourceAction(sourceName: String, actionName: String) extends Exception(s"$sourceName is an invalid source for the action $actionName") {
}
