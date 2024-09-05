package model.units

class Enemy(private val name: String, private var healthPoints: Int, private var defensePoints: Int, private val weight: Int) extends AbstractUnit(name, healthPoints, defensePoints, weight) {

}
