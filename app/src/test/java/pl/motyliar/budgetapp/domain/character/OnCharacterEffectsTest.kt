package pl.motyliar.budgetapp.domain.character

import org.junit.Assert.*
import org.junit.Test
import pl.motyliar.budgetapp.domain.character.subclass.OnCharacterEffects

class OnCharacterEffectsTest {

    @Test
    fun isCorrectInstance() {
        val effects = OnCharacterEffects()
        val secondEffects = OnCharacterEffects()
        secondEffects.poisonedEffect()
        secondEffects.clearAll()

        assertEquals(effects, secondEffects)
    }

    @Test
    fun checkIsThisSameStateOfClass() {
        val warrior = Warrior()
        warrior.onCharacterEffects.poisonedEffect()

        val effects = OnCharacterEffects()
        effects.poisonedEffect()
        println(warrior.onCharacterEffects.getEffectsStateInstance())
        println(effects)
        assertEquals(effects, warrior.onCharacterEffects.getEffectsStateInstance())

    }

    @Test
    fun checkIsDifferentStateOfClass() {
        val warrior = Warrior()
        warrior.onCharacterEffects.poisonedEffect()
        val effects = OnCharacterEffects()

        assertFalse(effects == warrior.onCharacterEffects.getEffectsStateInstance())

    }

}