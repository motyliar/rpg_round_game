package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.core.equatable.Equatable

sealed class CharacterType(val type: Kind) {
    object Knight : CharacterType(Kind.KNIGHT)
    object Monster : CharacterType(Kind.MONSTER)
    object Wizard : CharacterType(Kind.WIZARD)

    override fun equals(other: Any?): Boolean {
        return Equatable.getProps<CharacterType>(this, other)
    }

}


enum class Kind() {
    KNIGHT, MONSTER, WIZARD
}
