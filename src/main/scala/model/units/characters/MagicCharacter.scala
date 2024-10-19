package model.units.characters

import model.units.Units

// Trait defining magic-specific behavior for characters with mana points
trait MagicCharacter extends Units {

  def setMp(manaP: Int): Unit  // Set the character's mana points
  def getMp: Int  // Get the character's mana points
}
