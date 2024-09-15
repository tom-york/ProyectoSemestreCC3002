package model.units

abstract class AbstractMagicCharacter extends AbstractCharacter {

  private var manaPoints: Int = _

  def setMp(manaP: Int): Unit = {
    manaPoints = manaP
  }

  def getMp: Int = manaPoints

}
