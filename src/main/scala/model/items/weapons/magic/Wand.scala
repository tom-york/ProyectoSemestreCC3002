package model.items.weapons.magic

import model.items.weapons.AbstractMagicWeapon
import model.units.characters.Character

/**
 * A class representing a wand, a type of magic weapon with its own behavior for equipping.
 *
 * @param name The name of the wand.
 * @param attackPoints The attack points of the wand.
 * @param weight The weight of the wand.
 * @param magicAttackPoints The magic attack points of the wand.
 *
 * @constructor Initializes a new wand with the specified name, attack points, weight, and magic attack points.
 */
class Wand(name: String = "Wand", attackPoints: Int = 69, weight: Int = 69, magicAttackPoints: Int = 69) extends AbstractMagicWeapon(name, attackPoints, weight, magicAttackPoints) {

  /**
   * Equips the wand to a character.
   *
   * @param character The character to equip the wand to.
   */
  override def equipWeapon(character: Character): Unit = {
    character.equipWand(this)
  }
}