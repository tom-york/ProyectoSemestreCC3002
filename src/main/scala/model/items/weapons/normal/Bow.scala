package model.items.weapons.normal

import model.items.weapons.AbstractWeapon
import model.units.characters.Character

/**
 * A class representing a bow, a type of basic weapon with its own behavior for equipping.
 *
 * @param name The name of the bow.
 * @param attackPoints The attack points of the bow.
 * @param weight The weight of the bow.
 *
 * @constructor Initializes a new bow with the specified name, attack points, and weight.
 */
class Bow(name: String = "Bow", attackPoints: Int = 69, weight: Int = 69) extends AbstractWeapon(name, attackPoints, weight) {

  /**
   * Equips the bow to a character.
   *
   * @param character The character to equip the bow to.
   */
  override def equipWeapon(character: Character): Unit = {
    character.equipBow(this)
  }
}