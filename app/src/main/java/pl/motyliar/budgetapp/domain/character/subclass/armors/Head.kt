package pl.motyliar.budgetapp.domain.character.subclass.armors

import pl.motyliar.budgetapp.domain.character.subclass.Armor
import pl.motyliar.budgetapp.domain.character.subclass.ItemType

abstract class Head(
    name: String,
    type: ItemType,
    price: Int,
    resistance: Int,
    defence: Int
) :
    Armor(
        defence = defence,
        resistance = resistance,
        price = price,
        name = name,
        type = type
    ) {
}