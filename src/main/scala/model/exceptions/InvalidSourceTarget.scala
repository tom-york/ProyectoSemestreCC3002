package model.exceptions

class InvalidSourceTarget(sourceName: String, targetName: String) extends Exception(s"The source ${targetName} isn't compatible with the target ${sourceName}"){

}
