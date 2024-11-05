package model.exceptions

import model.units.characters.MagicCharacter

class InsufficientManaPoints (magicCharacter: MagicCharacter, actionName: String) extends Exception(s"${magicCharacter.getName} doesn't have enough mana points to execute the $actionName action."){

}
