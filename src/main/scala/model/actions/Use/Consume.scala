package model.actions.Use

import model.items.Potion

class Consume(name: String, usableItems: List[Potion]) extends UsageAction(name, usableItems) {

}
