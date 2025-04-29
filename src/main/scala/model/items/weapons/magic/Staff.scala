package model.items.weapons.magic

import model.items.weapons.AbstractMagicWeapon
import model.units.characters.Character

/**
 * A class representing a staff, a type of magic weapon with its own behavior for equipping.
 *
 * @param name The name of the staff.
 * @param attackPoints The attack points of the staff.
 * @param weight The weight of the staff.
 * @param magicAttackPoints The magic attack points of the staff.
 *
 * @constructor Initializes a new staff with the specified name, attack points, weight, and magic attack points.
 */
class Staff(name: String = "Staff", attackPoints: Int = 69, weight: Int = 69, magicAttackPoints: Int = 69) extends AbstractMagicWeapon(name, attackPoints, weight, magicAttackPoints) {

  /**
   * Equips the staff to a character.
   *
   * @param character The character to equip the staff to.
   */
  override def equipWeapon(character: Character): Unit = {
    character.equipStaff(this)
  }
}
