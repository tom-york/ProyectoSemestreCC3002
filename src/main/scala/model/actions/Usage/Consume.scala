package model.actions.Usage

import model.items.Potions.Potion

class Consume(name: String, usableItems: List[Potion]) extends UsageAction(name, usableItems) {

}
