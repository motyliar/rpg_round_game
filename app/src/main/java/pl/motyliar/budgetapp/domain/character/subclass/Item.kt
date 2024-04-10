package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.core.themes.structure.CustomList

abstract class Item(protected val name: String, val price: Int,val type: ItemType) {
    fun getFullName() : String {
        return "${type.name} $name"
    }
}


class Items : CustomList<Item>() {

}