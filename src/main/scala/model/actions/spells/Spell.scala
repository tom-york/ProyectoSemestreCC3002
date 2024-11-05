package model.actions.spells

import api.Target
import model.actions.AbstractAction
import model.exceptions.InvalidSourceAction
import model.units.Enemy
import model.units.characters.Character

// Abstract class for actions involving spells
abstract class Spell(name: String) extends AbstractAction(name) {

  override def normalCharacterExecute(character: Character, tgt: Target): Unit = {
    throw new InvalidSourceAction(character.getName, this.getName)
  }

  override def enemyExecute(enemy: Enemy, tgt: Target): Unit = {
    throw new InvalidSourceAction(enemy.getName, this.getName)
  }
  
}
