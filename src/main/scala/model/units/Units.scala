package model.units

import api.GameObject

// Trait defining common behavior for units in the game
trait Units extends GameObject {

  // Setters for name, health points, defense points, and weight
  def setName(sName: String): Unit
  def setHp(sHp: Int): Unit
  def setDp(sDp: Int): Unit
  def setWeight(sWeight: Int): Unit

  // Getters for name, health points, defense points, and weight
  def getName: String
  def getHp: Int
  def getDp: Int
  def getWeight: Int
  def getID: String

  // Calculates the maximum action bar for the unit
  def calculateActionBarMax: Double
}