package pl.motyliar.budgetapp.domain.character.subclass.armors

import pl.motyliar.budgetapp.domain.character.subclass.Armor
import pl.motyliar.budgetapp.domain.character.subclass.ItemType

abstract class Chest(
    name: String,
    type: ItemType,
    price: Int,

    override val defence: Int,
) :
    Armor(
        defence = defence,
        price = price,
        name = name,
        type = type
    ) {

}

class LeatherJacket(
    override val name: String = "Jacket",
    override val type: ItemType = ItemType.LEATHER,
    override val price: Int = 20,

    override val defence: Int = 20,
) : Chest(
    name,
    type,
    price,
    defence,
) {




}
