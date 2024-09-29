package model.units

abstract class AbstractUnit(private var name: String, private var healthPoints: Int, private var defensePoints: Int, private var weight: Int)  extends Units {

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