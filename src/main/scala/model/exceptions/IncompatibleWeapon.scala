package model.exceptions

import model.items.weapons.Weapon

/**
 * Exception thrown when attempting to equip an incompatible weapon to a character.
 *
 * @param weapon The weapon that is incompatible.
 * @param characterType The type of character attempting to equip the weapon.
 * @throws IncompatibleWeapon when attempting to equip a weapon that is not compatible with the character type.
 */
class IncompatibleWeapon(weapon: Weapon, characterType: String) extends Exception(s"${weapon.getName} is an invalid weapon for the $characterType character type") {
}

