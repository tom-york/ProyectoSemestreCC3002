package model.exceptions

import model.panels.IPanel

/**
 * Exception thrown when attempting to interact with a panel that is not adjacent to the current unit's position.
 *
 * @param panel The panel that was incorrectly targeted.
 * @throws NotAdjacentPanel when attempting to interact with a non-adjacent panel.
 */
class NotAdjacentPanel(panel: IPanel) extends Exception(s"${panel.getCoordinates} isn't an adjacent panel to the selected unit") {
}
