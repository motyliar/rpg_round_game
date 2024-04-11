package pl.motyliar.budgetapp.domain.character.subclass

abstract class Armor(open val defence: Int,
                     private var destruction: Int = 0,
                     name: String,
                     price: Int,
                     type : ItemType,
                     private var isDestroyed: Boolean = false ) : Item(name, price, type) {

    open fun getTotalDefence() : Int {
         return defence + type.extraDefence
     }
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

    override fun toString(): String {
        return "name $name"
    }

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(other !is Armor) return false

        if(defence != other.defence)return false
        if(destruction != other.destruction) return false
        return true
    }

    override fun hashCode(): Int {
        var result = defence.hashCode()
        result = 31 * result + destruction.hashCode()
        return result
    }

}