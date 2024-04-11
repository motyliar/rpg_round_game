package pl.motyliar.budgetapp.domain.character.subclass.armors

import pl.motyliar.budgetapp.domain.character.subclass.Armor
import pl.motyliar.budgetapp.domain.character.subclass.ItemType

abstract class Pants(
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