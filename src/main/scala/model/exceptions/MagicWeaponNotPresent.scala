package model.exceptions

/**
 * Exception thrown when attempting to use magic spells without an equipped magic weapon.
 *
 * @throws MagicWeaponNotPresent when attempting to cast spells without having a magic weapon equipped.
 */
class MagicWeaponNotPresent extends Exception(s"Can't use spells as it doesn't have an equipped magic weapon"){
}
