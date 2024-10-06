package model.items.Weapons

import model.items.Item

// Trait for magic weapons, which adds the concept of magic attack points
trait MagicWeapon extends Item {

  // Setter and getter for the magic attack points
  def setMagicAttackPoints(newMAp: Int): Unit
  def getMagicAttackPoints: Int
}
