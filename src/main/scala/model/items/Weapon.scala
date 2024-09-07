package model.items

import model.players.Player

abstract class Weapon(private val name: String, private val attackPoints: Int, private val weight: Int, private var owner: Player) extends Item {

  def getName: String = name

  def getAttackPoints: Int = attackPoints

  def getWeight: Int = weight

  def getOwner: Player = owner
  
}
