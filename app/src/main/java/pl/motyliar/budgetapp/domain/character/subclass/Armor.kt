package pl.motyliar.budgetapp.domain.character.subclass

abstract class Armor(private val defence: Int,
                     private var destruction: Int = 0,
                     name: String,
                     price: Int,
                     type : ItemType,
                     private var isDestroyed: Boolean = false ) : Item(name, price, type) {

    abstract fun getDefence() : Int
    open fun repair(value: Int) {
        destruction += value
    }
    open fun destruction(value: Int) {
        if((destruction + value) > 100 )
        { destruction = 100
            isDestroyed = true
        } else
            destruction += value
    }

    fun isArmorDestroyed(): Boolean {
        return isDestroyed

    }

}