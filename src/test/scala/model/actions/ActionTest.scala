package model.actions

import model.actions.Usage.{Consume, Equip}
import model.items.Potions.MagicPotions.ManaPotion
import model.items.Weapons.*
import model.items.Weapons.NormalWeapons.Bow
import model.units.Characters.NormalCharacters.Knight
import munit.FunSuite

class ActionTest extends FunSuite{
  private val potion1: ManaPotion = new ManaPotion("Potion")
  private val weapon1: Bow = new Bow("weapon", 90, 30, new Knight("lolo", 30, 30, 30, None, List()))
  private var equip: Equip = _
  private var consume: Consume = _

  override def beforeEach(context: BeforeEach): Unit = {
    equip = new Equip("eq", List(weapon1))
    consume = new Consume("co", List(potion1))
  }

  test("An action has a name.") {
    assertEquals(equip.getName, "eq")
  }

  test("An action that uses items has to have a list of the objects that it can use.") {
    assertEquals(equip.getUsableList, List(weapon1))
  }
}
