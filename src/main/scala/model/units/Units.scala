package model.units

trait Units {
  def setName(sName: String): Unit

  def setHp(sHp: Int): Unit

  def setDp(sDp: Int): Unit

  def setWeight(sWeight: Int): Unit 
  
  def getName: String

  def getHp: Int

  def getDp: Int

  def getWeight: Int

}
