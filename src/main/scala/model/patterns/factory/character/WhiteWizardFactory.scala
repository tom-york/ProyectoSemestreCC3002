package model.patterns.factory.character

import model.panels.Panel
import model.units.characters.Character
import model.units.characters.magic.WhiteWizard


object WhiteWizardFactory extends CharacterFactory {
  override def apply(): Character = new WhiteWizard("WhiteWizard", 90, 60, 30, new Panel(), List(), 40)
}
