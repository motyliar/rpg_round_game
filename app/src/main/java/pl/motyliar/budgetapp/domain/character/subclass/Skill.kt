package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.domain.character.Character

abstract class Skill(
    name: String,
    attack: Int,
    useRequirements: Int,
    buyRequirements: Int,
    specialEffects: Int?,

) {
    abstract fun use()
    fun canIUse(character: Character): Boolean {
        return true
    }

}