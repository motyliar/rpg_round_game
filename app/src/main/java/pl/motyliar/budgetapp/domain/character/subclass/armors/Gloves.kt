package pl.motyliar.budgetapp.domain.character.subclass.armors

import pl.motyliar.budgetapp.domain.character.subclass.*

abstract class Gloves(
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