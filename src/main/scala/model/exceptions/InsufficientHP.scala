package model.exceptions

import model.units.Units

class InsufficientHP(unit: Units) extends Exception(s"${unit.getName} doesn't have enough health points to execute an action.") {

}
