package model.units.characters

import api.Target
import model.actions.Action
import model.actions.base.*
import model.actions.usage.*
import model.exceptions.{InsufficientHP, WeaponNotPresent}
import model.items.Item
import model.items.potions.Potion
import model.items.potions.normal.*
import model.items.weapons.Weapon
import model.panels.IPanel

abstract class AbstractNormalCharacter(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, itemInventory: List[Item]) extends AbstractCharacter(name, healthPoints, defensePoints, weight, panel, itemInventory) {
  
  protected def compatibleWeapons: List[Weapon]
  
  protected val compatibleConsumables: List[Potion] = List(new HealingPotion("HealPot"), new StrengthPotion("StrengthPot"))

  override val actions: List[Action] = List(new Attack(), new Move(), new Consume("Consume", compatibleConsumables), new Equip("Equip", this.compatibleWeapons))

  def doAction(action: Action, target: Target): Unit = {
    if (healthPoints <= 0) {
      throw new InsufficientHP(this)
    }
    else {
      action.normalCharacterExecute(this, target)
    }
  }
}
