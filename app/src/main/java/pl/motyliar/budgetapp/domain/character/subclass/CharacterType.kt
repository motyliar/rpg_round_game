package pl.motyliar.budgetapp.domain.character.subclass

sealed class CharacterType(val type: Kind) {
    object Warrior : CharacterType(Kind.WARRIOR)
    object Monster : CharacterType(Kind.MONSTER)
    object Wizard : CharacterType(Kind.WIZARD)

}


enum class Kind(type: String) {
    WARRIOR("warrior"), MONSTER("monster"), WIZARD("wizard")
}
