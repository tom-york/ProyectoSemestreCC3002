package model.patterns.factory.character

import model.panels.Panel
import model.units.characters.Character
import model.units.characters.normal.Thief


object ThiefFactory extends CharacterFactory {
  override def apply(): Character = new Thief("Thief", 90, 60, 30, new Panel(), List())
}
