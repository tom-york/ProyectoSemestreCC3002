package model.items.weapons.normal

import model.items.weapons.AbstractWeapon
import model.units.characters.Character

/**
 * A class representing a dagger, a type of basic weapon with its own behavior for equipping.
 *
 * @param name The name of the dagger.
 * @param attackPoints The attack points of the dagger.
 * @param weight The weight of the dagger.
 *
 * @constructor Initializes a new dagger with the specified name, attack points, and weight.
 */
class Dagger(name: String = "Dagger", attackPoints: Int = 69, weight: Int = 69) extends AbstractWeapon(name, attackPoints, weight) {

  /**
   * Equips the dagger to a character.
   *
   * @param character The character to equip the dagger to.
   */
  override def equipWeapon(character: Character): Unit = {
    character.equipDagger(this)
  }
}

