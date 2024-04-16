package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.core.equatable.Equatable

class OnCharacterEffects(
    private var stunned: Boolean = false,
    private var poisoned: Boolean = false,
    private var confusion: Boolean = false,
    private var blinded: Boolean = false,
    private var healBlocked: Boolean = false
) {


    fun getEffectsStateInstance(): OnCharacterEffects {
        return OnCharacterEffects(stunned, poisoned, confusion, blinded, healBlocked)

    }


    fun clearAll() {
        stunned = false
        poisoned = false
        confusion = false
        blinded = false
        healBlocked = false
    }

    fun stunEffect() {
        stunned = true
    }

    fun poisonedEffect() {
        poisoned = true
    }

    fun confusionEffect() {
        confusion = true
    }

    fun blindedEffect() {
        blinded = true
    }

    fun healBlockedEffect() {
        healBlocked = true
    }

    override fun toString(): String {
        return "OnCharacterEffects(stunned: $stunned, poisoned: $poisoned, confusion: $confusion, blinded: $blinded, healBlocked: $healBlocked)"
    }


    override fun equals(other: Any?): Boolean {

        return Equatable.getProps<OnCharacterEffects>(this, other)


    }

}
