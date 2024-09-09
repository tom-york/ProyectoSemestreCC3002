package model.units

class Enemy extends AbstractUnit {

  private var attackPoints: Int = _

   def setAtk(sAtk: Int): Unit = {
    attackPoints = sAtk
  }

  def getAtk: Int = attackPoints
  
}
