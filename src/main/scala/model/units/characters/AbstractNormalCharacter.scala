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

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * Abstract class for normal characters, extending `AbstractCharacter`.
 *
 * This class provides the base functionality for non-magic-focused character entities in the game.
 *
 * @param name The name of the normal character.
 * @param healthPoints The maximum health points of the normal character.
 * @param defensePoints The defense points of the normal character.
 * @param weight The weight of the normal character.
 * @param panel The panel associated with the normal character.
 * @param itemInventory The initial list of items in the normal character's inventory.
 */
abstract class AbstractNormalCharacter(name: String, healthPoints: Int, defensePoints: Int, weight: Int, panel: IPanel, itemInventory: ArrayBuffer[Item]) extends AbstractCharacter(name, healthPoints, defensePoints, weight, panel, itemInventory) {

  override def init(): Unit = {
    for (x <- 0 until 2) {
      itemInventory += compatibleWeaponFactories(Random.between(0, 3))()
    }
    for (x <- 0 until 2) {
      itemInventory += compatiblePotionFactories(Random.between(0, 2))()
    }
  }
  
  protected def compatibleWeapons: List[Weapon]

  protected val compatibleConsumables: List[Potion] = List(new HealingPotion("HealPot"), new StrengthPotion("StrengthPot"))

  override val actions: List[Action] = List(new Attack(), new Move(), new Consume("Consume", compatibleConsumables), new Equip("Equip", this.compatibleWeapons))

  /**
   * Executes an action for the normal character, throwing an `InsufficientHP` exception if the character's health points are 0.
   *
   * @param action The action to be executed.
   * @param target The target of the action.
   * @throws InsufficientHP If the normal character's health points are 0.
   */
  def doAction(action: Action, target: Target): Unit = {
    if (getHp == 0) {
      throw new InsufficientHP(this)
    }
    else {
      action.normalCharacterExecute(this, target)
    }
  }
}
