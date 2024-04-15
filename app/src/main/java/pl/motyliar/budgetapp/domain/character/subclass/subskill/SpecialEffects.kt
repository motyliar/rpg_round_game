package pl.motyliar.budgetapp.domain.character.subclass.subskill

import pl.motyliar.budgetapp.domain.character.Character

interface SpecialEffects {
    fun setSpecialEffect(character: Character)
}


class Stun : SpecialEffects {
    override fun setSpecialEffect(character: Character) {
        character.onCharacterEffects.stunEffect()
    }
}

class Poison : SpecialEffects {
    override fun setSpecialEffect(character: Character) {
        character.onCharacterEffects.poisonedEffect()
    }
}

class Confusion : SpecialEffects {
    override fun setSpecialEffect(character: Character) {
        character.onCharacterEffects.confusionEffect()
    }
}

class Blind : SpecialEffects {
    override fun setSpecialEffect(character: Character) {
        character.onCharacterEffects.blindedEffect()
    }
}

class HealBlock : SpecialEffects {
    override fun setSpecialEffect(character: Character) {
        character.onCharacterEffects.blindedEffect()
    }
}