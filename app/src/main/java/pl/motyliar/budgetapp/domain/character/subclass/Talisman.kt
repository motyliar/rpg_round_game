package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.core.equatable.Equatable

class Talisman(name: String, type: ItemType, price: Int, private var extraPoints: Int, private val talismanKind: TalismanKind) : Item(name,price, type) {
    fun getExtraPoints(kind: TalismanKind): Int {
        var talismanPoints: Int = 0
        if (talismanKind == kind) {
            when (kind) {
                TalismanKind.MAGIC -> talismanPoints = extraPoints
                TalismanKind.DEXTERITY ->talismanPoints = extraPoints
                TalismanKind.POWER -> talismanPoints = extraPoints
                TalismanKind.INTELLIGENCE -> talismanPoints = extraPoints
                TalismanKind.DEFENCE -> talismanPoints = extraPoints
            }
        }
        return talismanPoints

    }
    override fun equals(other: Any?): Boolean {

        return Equatable.getProps<Talisman>(this, other)

    }

}


enum class TalismanKind {
    MAGIC, POWER, INTELLIGENCE, DEXTERITY, DEFENCE
}


