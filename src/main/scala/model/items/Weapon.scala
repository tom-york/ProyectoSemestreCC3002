package model.items

import model.players.Player

trait Weapon extends Item {
  
  def getName: String
  
  def getAttackPoints: Int
  
  def getWeight: Int
  
  def getOwner: Player
}
