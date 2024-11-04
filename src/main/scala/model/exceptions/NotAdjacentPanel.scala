package model.exceptions

import model.panels.IPanel

class NotAdjacentPanel(panel: IPanel) extends Exception(s"${panel.getCoordinates} isn't an adjacent panel to the selected unit") {

}
