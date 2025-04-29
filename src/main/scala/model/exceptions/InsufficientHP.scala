package model.exceptions

import model.units.Units

/**
 * Exception thrown when a unit has insufficient health points to perform an action.
 *
 * @param unit The unit that lacks sufficient health points.
 * @throws InsufficientHP when a unit attempts to perform an action without enough health points.
 */
class InsufficientHP(unit: Units) extends Exception(s"${unit.getName} doesn't have enough health points to execute an action.") {
}
