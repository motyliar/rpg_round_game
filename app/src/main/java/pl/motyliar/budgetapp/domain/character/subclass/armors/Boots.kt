package pl.motyliar.budgetapp.domain.character.subclass.armors

import pl.motyliar.budgetapp.domain.character.subclass.Armor
import pl.motyliar.budgetapp.domain.character.subclass.ItemType

abstract class Boots(
    override val defence: Int,
    name: String,
    type: ItemType,
    price: Int,


) :
    Armor(
        defence = defence,
        price = price,
        name = name,
        type = type
    ) {

}


class LeatherBoots(
    override val name: String = "Boots",
    override val type: ItemType = ItemType.LEATHER,
    override val price: Int = 20,
    override val defence: Int = 20,)
     : Boots(defence,name, type, price) {

}