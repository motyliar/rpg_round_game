package pl.motyliar.budgetapp.domain.character.subclass

enum class ItemType(val extraDefence: Int, val material: String,) {
    MAGIC(10, "Magic"),
    STEEL(0, "Steel"),
    GOD(25, "God"),
    BLACKSTEEL(5, "Black Steel"),
    KEVLAR(8, "Kevlar"),
    LEATHER(2, "Leather")



}