package model.patterns.factory.character

import model.panels.Panel
import model.units.characters.Character
import model.units.characters.magic.BlackWizard

object BlackWizardFactory extends CharacterFactory {
  override def apply(): Character = new BlackWizard("Black Wizard", 90, 60, 30, new Panel(), List(), 40)
}
