package model.units

import api.{Source, Target}
import model.actions.Action
import model.exceptions.{DefeatedTarget, InvalidActionTarget, NoIdFound}
import model.panels.IPanel
import model.units.characters.{Character, MagicCharacter}

import java.util.UUID

// Abstract class implementing the Units trait with basic fields and methods
abstract class AbstractUnit(override val name: String, private val maxHealthPoints: Int, private var defensePoints: Int, private var weight: Int, private var panel: IPanel) extends Units with Source with Target {

  private var healthPoints: Int = maxHealthPoints
  
  panel.addUnit(this)
  
  // Setters for the unit's properties
  override def setHp(sHp: Int): Unit = {
    if (0 <= sHp && sHp <= maxHealthPoints) {
      healthPoints = sHp
    }
    else {
      throw new IllegalArgumentException("Either the new HP is negative or over the maximum HP allowed")
    }
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
  override def getMaxHp: Int = maxHealthPoints

  val id: String = UUID.randomUUID().toString

  override def findActionById(actionId: String): Action = {
    val actionList: List[Action] = this.actions
    actionList.find(_.getId == actionId).getOrElse(
      throw new NoIdFound(actionId)
    )
  }

  override def beAttacked(attackDmg: Int): Unit = {
    val netAttack: Int = attackDmg - defensePoints
    if (netAttack >= 0) {
      if (netAttack > healthPoints) {
        setHp(0)
      }
      else {
        setHp(healthPoints - netAttack)
      }
    }
  }

  override def useThunder(magicCharacter: MagicCharacter): Unit = {
    if (getHp == 0) {
      throw new DefeatedTarget(this)
    }
    else {
      val damageAmount: Int = magicCharacter.getMagicDamage
      beAttacked(damageAmount)
    }
  }
  
  override def moveUnit(unit: Units): Unit = {
    throw new InvalidActionTarget("Unit", "Move")
  }

  override def equipWeapon(character: characters.Character): Unit = {
    throw new InvalidActionTarget("Unit", "Equip")
  }

  override def useMeteorite(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Unit", "Meteorite")
  }
  
  override def magicCharacterConsume(magicCharacter: MagicCharacter): Unit = {
    throw new InvalidActionTarget("Unit", "Consume")
  }
  
  override def characterConsume(character: Character): Unit = {
    throw new InvalidActionTarget("Unit", "Consume")
  }
}