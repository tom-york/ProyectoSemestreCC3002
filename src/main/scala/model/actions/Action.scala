package model.actions

import api.{Source, Target}

// Trait defining basic actions with a name
trait Action {
  def setName(name: String): Unit // Sets the action's name
  
  def getName: String // Retrieves the action's name
  
  def apply(src: Source, tgt: Target): Unit 
}
