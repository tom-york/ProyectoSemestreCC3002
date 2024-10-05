package model.items.Potions

import util.Json.{*, given}

abstract class AbstractPotion(private var name: String) extends Potion {

  def setName(newName: String): Unit = {
    name = newName
  }

  def getName: String = name

  override def toJson: JsObj = JsObj(
    "id" -> this.id,
    "name" -> getName
  )

}
