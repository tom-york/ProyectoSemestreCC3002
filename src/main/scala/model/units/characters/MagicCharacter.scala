package model.units.characters

import model.units.Units

/**
 * Trait defining magic-specific behavior for characters with mana points.
 *
 * This trait provides the additional methods and properties that magic-focused character entities
 * should have, such as managing their mana points, applying magic force effects, and calculating
 * their magic damage.
 */
trait MagicCharacter extends Character {

  /**
   * Sets the magic character's mana points.
   *
   * @param manaP The new value for the magic character's mana points.
   */
  def setMp(manaP: Int): Unit

  /**
   * Gets the magic character's current mana points.
   *
   * @return The magic character's current mana points.
   */
  def getMp: Int

  /**
   * Gets the magic character's maximum mana points.
   *
   * @return The magic character's maximum mana points.
   */
  def getMaxMp: Int

  /**
   * Applies the magic force potion effect, increasing the magic character's magic damage multiplier.
   */
  def magicForcePotionEffect(): Unit

  /**
   * Resets the magic character's magic damage multiplier to the default value of 1.0.
   */
  def magicForceReset(): Unit

  /**
   * Gets the magic character's current magic damage, based on their equipped weapon and the magic force multiplier.
   *
   * @return The magic character's current magic damage.
   */
  def getMagicDamage: Int
}
