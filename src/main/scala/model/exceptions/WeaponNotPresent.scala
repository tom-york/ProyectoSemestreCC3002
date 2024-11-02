package model.exceptions

import model.units.characters.Character

class WeaponNotPresent(char: Character) extends Exception(s"${char.getName} can't attack as it doesn't have an equipped weapon"){

}
