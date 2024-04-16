package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.core.equatable.Equatable
import pl.motyliar.budgetapp.core.themes.structure.CustomList


abstract class Item(protected open val name: String,open val price: Int, open val type: ItemType, open val image: String = "") {
    fun getFullName() : String {

        return "${type.name.lowercase().capitalize()} $name"
    }

    override fun equals(other: Any?): Boolean {

        return Equatable.getProps<Item>(this, other)

    }
}


class Items : CustomList<Item>() {

}