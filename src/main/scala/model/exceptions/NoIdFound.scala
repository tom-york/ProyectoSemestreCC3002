package model.exceptions

class NoIdFound(id: String) extends Exception(s"The id $id couldn't be found and fetched.") {

}
