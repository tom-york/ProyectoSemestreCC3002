package model.exceptions

import model.actions.Action

class InvalidActionTarget(targetName: String, actionName: String) extends Exception(s"${targetName} is an invalid target for the action ${actionName}") {

}
