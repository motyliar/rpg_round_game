package pl.motyliar.budgetapp.domain.character.subclass.armors

import pl.motyliar.budgetapp.domain.character.subclass.Armor
import pl.motyliar.budgetapp.domain.character.subclass.ItemType

abstract class Chest(
    name: String,
    type: ItemType,
    price: Int,
    destruction: Int,
    defence: Int
) :
    Armor(
        defence = defence,
        destruction = destruction,
        price = price,
        name = name,
        type = type
    ) {
}

class LeatherJacket(
    override val name: String = "Jacket",
    override val type: ItemType = ItemType.LEATHER,
    override val price: Int = 20,
    private val resistance: Int = 20,
    private val defence: Int = 20,
) : Chest(
    name,
    type,
    price,
    resistance,
    defence,
) {
    override fun getDefence() : Int {
        val totalDefence = defence + type.extraDefence
        return totalDefence
    }

    override fun repair(value: Int) {

    }

}
