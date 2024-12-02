package model.patterns.factory.character

import model.panels.Panel
import model.units.characters.Character
import model.units.characters.normal.Knight


object KnightFactory extends CharacterFactory {
  override def apply(): Character = new Knight("Knight", 90, 60, 30, new Panel(), List())
}
