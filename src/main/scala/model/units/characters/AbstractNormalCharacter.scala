package model.units.characters

import api.Target
import model.actions.Action
import model.actions.base.*
import model.actions.usage.*
import model.exceptions.WeaponNotPresent
import model.items.Item
import model.items.potions.Potion
import model.items.potions.normal.*
import model.items.weapons.Weapon
import model.panels.IPanel

abstract class AbstractNormalCharacter(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, weaponSlot: Option[Weapon], itemInventory: List[Item]) extends AbstractCharacter(name, healthPoints, defensePoints, weight, panel, weaponSlot, itemInventory) {
  override def getTotalDamage: Int = weaponSlot.getOrElse(throw new WeaponNotPresent(this)).getTotalAttack
  
  protected def compatibleWeapons: List[Weapon]
  
  protected val compatibleConsumables: List[Potion] = List(new HealingPotion("HealPot"), new StrengthPotion("StrengthPot"))

  override val actions: List[Action] = List(new Attack(), new Move(), new Consume("Consume", compatibleConsumables), new Equip("Equip", this.compatibleWeapons))

  def doAction(action: Action, target: Target): Unit = {
    action.normalCharacterExecute(this, target)
  }
}
