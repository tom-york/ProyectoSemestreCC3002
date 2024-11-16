package model.exceptions

import model.units.characters.Character

/**
 * Exception thrown when a character attempts to attack without having a weapon equipped.
 *
 * @param char The character attempting to attack without an equipped weapon.
 * @throws WeaponNotPresent when a character tries to perform an attack action without having any weapon equipped.
 */
class WeaponNotPresent(char: Character) extends Exception(s"${char.getName} can't attack as it doesn't have an equipped weapon"){
}
