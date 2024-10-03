package model.units.Characters

import model.units.Units

trait MagicCharacter extends Units {

  def setMp(manaP: Int): Unit

  def getMp: Int

}
