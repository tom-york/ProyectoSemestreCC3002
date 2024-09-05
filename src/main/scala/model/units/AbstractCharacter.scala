package model.units

import model.items.{Item, Weapon}


class AbstractCharacter(private val name: String, private var healthPoints: Int, private var defensePoints: Int, private val weight: Int, private var weaponSlot: Weapon, private var itemInventory: List[Item]) extends AbstractUnit(name, healthPoints, defensePoints, weight) {

}
