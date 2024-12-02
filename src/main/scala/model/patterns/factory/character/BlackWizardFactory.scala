package model.patterns.factory.character

import model.panels.Panel
import model.units.characters.Character
import model.units.characters.magic.BlackWizard
import scala.collection.mutable.ArrayBuffer

object BlackWizardFactory extends CharacterFactory {
  override def apply(panel: Panel): Character = new BlackWizard("Black Wizard", 90, 60, 30, panel, ArrayBuffer(), 40)
}
