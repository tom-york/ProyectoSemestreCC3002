package model.actions

import api.{Source, Target}
import model.units.Enemy
import model.units.characters.Character

// Trait defining basic actions with a name
trait Action {
  def setName(name: String): Unit // Sets the action's name
  
  def getName: String // Retrieves the action's name

  def enemyExecute(enemy: Enemy, tgt: Target): Unit

  def characterExecute(character: Character, tgt: Target): Unit
}
