package model.units

abstract class AbstractUnit(private val name: String, private var healthPoints: Int, private var defensePoints: Int, private val weight: Int) extends Units {

  override def getName: String = name

  override def getHp: Int = healthPoints

  override def getDp: Int = defensePoints

  override def getWeight: Int = weight

}