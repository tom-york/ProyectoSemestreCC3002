package model.items.potions

import util.Json.{*, given}

import java.util.UUID

// Abstract class implementing the Potion trait, defining a basic potion
abstract class AbstractPotion(private var name: String) extends Potion {

  // Setter and getter for the potion's name
  def setName(newName: String): Unit = {
    name = newName
  }

  def getName: String = name

  val id: String = UUID.randomUUID().toString
  
  // Serialize the potion to JSON format
  override def toJson: JsObj = JsObj(
    "id" -> id,
    "name" -> getName
  )
}
