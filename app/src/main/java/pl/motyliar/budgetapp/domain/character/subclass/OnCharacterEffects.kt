package pl.motyliar.budgetapp.domain.character.subclass

class OnCharacterEffects(
    private var stunned: Boolean = false,
    private var poiosoned: Boolean = false,
    private var confusion: Boolean = false,
    private var blinded: Boolean = false,
    private var healBlocked: Boolean = false
) {
    init {
        clearAll()
    }

    fun getEffectsStateInstance(): OnCharacterEffects {
        return OnCharacterEffects(stunned, poiosoned, confusion, blinded, healBlocked)

    }


    fun clearAll() {
        stunned = false
        poiosoned = false
        confusion = false
        blinded = false
        healBlocked = false
    }

    fun stunEffect() {
        stunned = true
    }

    fun poisonedEffect() {
        poiosoned = true
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

}
