package model.exceptions

/**
 * Exception thrown when attempting to perform an action on an invalid target.
 *
 * @param targetName The name of the invalid target.
 * @param actionName The name of the action being attempted.
 * @throws InvalidActionTarget when attempting to perform an action on a target that cannot receive it.
 */
class InvalidActionTarget(targetName: String, actionName: String) extends Exception(s"$targetName is an invalid target for the action $actionName") {
}
