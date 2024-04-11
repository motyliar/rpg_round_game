package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.core.themes.structure.CustomList


abstract class Item(protected open val name: String,open val price: Int, open val type: ItemType, open val image: String = "") {
    fun getFullName() : String {

        return "${type.name.lowercase().capitalize()} $name"
    }
}


class Items : CustomList<Item>() {

}