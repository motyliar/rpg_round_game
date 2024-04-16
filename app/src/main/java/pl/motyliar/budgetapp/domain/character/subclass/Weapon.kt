package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.core.equatable.Equatable


abstract class Weapon(
    open val power: Int,
    open val resilience: Int,
    open val isOneHanded: Boolean,
    open var defence: Int,
    name: String,
    price: Int,
    type: ItemType
) :
    Item(name, price, type) {
    override fun equals(other: Any?): Boolean {

        return Equatable.getProps<Weapon>(this, other)

    }

}

data class Sword(
    override val power: Int = 20,
    override val resilience: Int = 20,
    override  val isOneHanded: Boolean = true,
    override val name: String = "sword",
    override var defence: Int = 8,
    override val price: Int = 20,
    override val type: ItemType = ItemType.STEEL
) : Weapon(power, resilience, isOneHanded, defence, name,  price, type,) {

}



