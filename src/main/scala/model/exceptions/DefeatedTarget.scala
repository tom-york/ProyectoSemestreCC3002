package model.exceptions

import model.units.Units

/**
 * Exception thrown when attempting to perform an action on a defeated unit.
 *
 * @param unit The defeated unit that cannot receive actions.
 * @throws DefeatedTarget when attempting to perform an action on a defeated unit.
 */
class DefeatedTarget(unit: Units) extends Exception(s"${unit.getName} is defeated, so it can't receive an action.") {
}
