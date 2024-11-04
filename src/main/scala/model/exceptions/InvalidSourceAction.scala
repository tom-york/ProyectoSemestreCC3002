package model.exceptions

class InvalidSourceAction(sourceName: String, actionName: String) extends Exception(s"$sourceName is an invalid source for the action $actionName") {

}
