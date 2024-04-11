package pl.motyliar.budgetapp.domain.character.subclass

class Talisman(name: String, type: ItemType, price: Int, private var extraPoints: Int, private val talismanKind: TalismanKind) : Item(name,price, type) {
    fun getExtraPoints(kind: TalismanKind): Int {
        var talismanPoints: Int = 0
        if (talismanKind == kind) {
            when (kind) {
                TalismanKind.MAGIC -> talismanPoints = extraPoints
                TalismanKind.DEXTERITY ->talismanPoints = extraPoints
                TalismanKind.POWER -> talismanPoints = extraPoints
                TalismanKind.INTELLIGENCE -> talismanPoints = extraPoints
            }
        }
        return talismanPoints

    }

}


enum class TalismanKind {
    MAGIC, POWER, INTELLIGENCE, DEXTERITY
}


