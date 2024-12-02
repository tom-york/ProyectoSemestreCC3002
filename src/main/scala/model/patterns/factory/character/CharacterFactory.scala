package model.patterns.factory.character

import model.panels.Panel
import model.units.characters.Character

trait CharacterFactory {
  def apply(panel: Panel): Character
}
