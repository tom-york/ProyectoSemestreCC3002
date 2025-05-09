package model.patterns.factory.character

import model.panels.Panel
import model.units.characters.Character
import model.units.characters.magic.WhiteWizard

import scala.collection.mutable.ArrayBuffer


object WhiteWizardFactory extends CharacterFactory {
  override def apply(panel: Panel): Character = new WhiteWizard("WhiteWizard", 90, 60, 30, panel, ArrayBuffer(), 40)
}
