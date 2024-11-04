package model.units

import api.{Source, Target}
import model.actions.Action
import model.panels.IPanel

import java.util.UUID

// Abstract class implementing the Units trait with basic fields and methods
abstract class AbstractUnit(override val name: String, private var healthPoints: Int, private var defensePoints: Int, private var weight: Int, private var panel: IPanel) extends Units with Source with Target {

  panel.addUnit(this)
  
  // Setters for the unit's properties
  override def setHp(sHp: Int): Unit = {
    healthPoints = sHp
  }

  override def setDp(sDp: Int): Unit = {
    defensePoints = sDp
  }

  override def setWeight(sWeight: Int): Unit = {
    weight = sWeight
  }
  
  override def movePanel(newPanel: IPanel): Unit = {
    panel.removeUnit(this)
    panel = newPanel
    panel.addUnit(this)
  }

  // Getters for the unit's properties
  override def getName: String = name
  override def getHp: Int = healthPoints
  override def getDp: Int = defensePoints
  override def getWeight: Int = weight
  override def getPanel: IPanel = panel

  val id: String = UUID.randomUUID().toString

  override def beAttacked(attackDmg: Int): Unit = {
    healthPoints = healthPoints - attackDmg
  }
}