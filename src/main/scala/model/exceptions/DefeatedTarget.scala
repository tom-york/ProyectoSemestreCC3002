package model.exceptions

import model.units.Units

class DefeatedTarget(unit: Units) extends Exception(s"${unit.getName} is defeated, so it can't receive an action.") {

}
