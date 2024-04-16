package pl.motyliar.budgetapp.core.themes.structure

import pl.motyliar.budgetapp.core.equatable.Equatable
import pl.motyliar.budgetapp.domain.character.subclass.Talisman
import java.util.ArrayList


open class CustomList<T> {
    private val children: MutableList<T> = ArrayList<T>()

    fun add(item: T) {
        children.add(item)
    }

    fun delete(item: T) {
        children.remove(item)
    }

    override fun equals(other: Any?): Boolean {

        return Equatable.getProps(this, other)

    }


}