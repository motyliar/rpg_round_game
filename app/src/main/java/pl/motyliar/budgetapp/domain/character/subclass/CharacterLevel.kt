package pl.motyliar.budgetapp.domain.character.subclass

abstract class CharacterLevel(val level: Int, val requiredExp: Int) {
    fun getLevel() {

    }
}


class LevelOne() : CharacterLevel(level = 1, requiredExp = 0)