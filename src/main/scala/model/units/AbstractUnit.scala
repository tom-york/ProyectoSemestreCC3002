package model.units

abstract class AbstractUnit extends Units {

  private var name: String = _

  private var healthPoints: Int = _

  private var defensePoints: Int = _

  private var weight: Int = _

  override def setName(sName: String): Unit = {
    name = sName
  }

  override def setHp(sHp: Int): Unit = {
    healthPoints = sHp
  }

  override def setDp(sDp: Int): Unit = {
    defensePoints = sDp
  }

  override def setWeight(sWeight: Int): Unit = {
    weight = sWeight
  }

  override def getName: String = name

  override def getHp: Int = healthPoints

  override def getDp: Int = defensePoints

  override def getWeight: Int = weight

}