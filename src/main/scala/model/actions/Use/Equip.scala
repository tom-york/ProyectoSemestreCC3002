package model.actions.Use

import model.items.Weapon

class Equip(name: String, usableItems: List[Weapon]) extends UsageAction(name, usableItems){

}
