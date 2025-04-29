package model.items.weapons.normal

import model.items.weapons.AbstractWeapon
import model.units.characters.Character

/**
 * A class representing a sword, a type of basic weapon with its own behavior for equipping.
 *
 * @param name The name of the sword.
 * @param attackPoints The attack points of the sword.
 * @param weight The weight of the sword.
 *
 * @constructor Initializes a new sword with the specified name, attack points, and weight.
 */
class Sword(name: String = "Sword", attackPoints: Int = 69, weight: Int = 69) extends AbstractWeapon(name, attackPoints, weight) {

  /**
   * Equips the sword to a character.
   *
   * @param character The character to equip the sword to.
   */
  override def equipWeapon(character: Character): Unit = {
    character.equipSword(this)
  }
}