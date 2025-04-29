package model.exceptions

import model.units.characters.MagicCharacter

/**
 * Exception thrown when a magic character has insufficient mana points to perform a specific action.
 *
 * @param magicCharacter The magic character attempting to perform the action.
 * @param actionName The name of the action that requires mana points.
 * @throws InsufficientManaPoints when a magic character attempts to perform an action without enough mana points.
 */
class InsufficientManaPoints(magicCharacter: MagicCharacter, actionName: String) extends Exception(s"${magicCharacter.getName} doesn't have enough mana points to execute the $actionName action.") {
}
