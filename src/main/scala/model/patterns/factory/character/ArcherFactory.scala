package model.patterns.factory.character
import model.panels.Panel
import model.units.characters.Character
import model.units.characters.normal.Archer
import scala.collection.mutable.ArrayBuffer

object ArcherFactory extends CharacterFactory {
  override def apply(panel: Panel): Character = new Archer("Archer", 90, 60, 30, panel, ArrayBuffer())
}
