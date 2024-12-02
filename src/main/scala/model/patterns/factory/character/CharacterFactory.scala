package model.patterns.factory.character

import model.units.characters.Character

trait CharacterFactory {
  def apply(): Character
}
