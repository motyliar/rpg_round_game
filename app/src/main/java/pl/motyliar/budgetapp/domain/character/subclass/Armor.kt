package pl.motyliar.budgetapp.domain.character.subclass

abstract class Armor(private val defence: Int,private val resistance: Int, name: String, price: Int,type : ItemType ) : Item(name, price, type) {

    abstract fun getDefence()
    abstract fun repair()

}