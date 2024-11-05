package model.exceptions

import model.items.weapons.Weapon

class IncompatibleWeapon (weapon: Weapon, characterType: String) extends Exception(s"${weapon.getName} is an invalid weapon for the $characterType character type") {

}

