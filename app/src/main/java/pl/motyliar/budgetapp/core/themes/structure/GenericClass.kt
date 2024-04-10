package pl.motyliar.budgetapp.core.themes.structure

import java.util.ArrayList


open class CustomList<T> {
    private val children: MutableList<T> = ArrayList<T>()

    fun add(item: T) {
        children.add(item)
    }

    fun delete(item: T) {
        children.remove(item)
    }


}