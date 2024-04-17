package pl.motyliar.budgetapp.domain.character

import org.junit.Assert.*
import org.junit.Test
import pl.motyliar.budgetapp.domain.character.helpers.KnightTest
import pl.motyliar.budgetapp.domain.character.helpers.KnightTesting

class VitalityTests {



    @Test
    fun getInitialLife() {
        val warrior = KnightTesting()
        assertEquals(50, warrior.vitality.getCurrentLife())
    }

    @Test
    fun addLifeAndGetActualLife() {
        val warrior = KnightTesting()
        warrior.vitality.addLife(20)
        assertEquals(70, warrior.vitality.getCurrentLife())
    }

    @Test
    fun getCurrentLifeAfterDamages() {
        val warrior = KnightTesting()
        warrior.vitality.addLife(10)
        warrior.vitality.addDamages(20)

        assertEquals(40, warrior.vitality.getCurrentLife())
    }

    @Test
    fun shouldAddIntelligenceValue() {
        val warrior = KnightTesting()
        warrior.vitality.addIntelligence(10)

        assertEquals(25, warrior.vitality.intelligence)
    }

    @Test
    fun shouldReturnCurrentDamageValue() {
        val warrior = KnightTesting()
        warrior.vitality.addDamages(20)
        assertEquals(20, warrior.vitality.getDamage)
    }
    @Test
    fun shouldReturnCurrentDamageAfterRecovering() {
        val warrior = KnightTesting()
        warrior.vitality.addDamages(20)
        warrior.vitality.recoveringHealth(10)
        assertEquals(10, warrior.vitality.getDamage)

    }

    @Test
    fun shouldReturnZeroDamageWhenIsOverRecovering() {
        val warrior = KnightTesting()
        warrior.vitality.addDamages(20)
        warrior.vitality.recoveringHealth(30)
        assertEquals(0, warrior.vitality.getDamage)

    }

    @Test
    fun shouldReturnCurrentFatigueValue() {
        val warrior = KnightTesting()
        warrior.vitality.addFatigue(20)
        assertEquals(20, warrior.vitality.getFatigue)
    }
    @Test
    fun shouldReturnCurrentEnergy() {
        val warrior = KnightTesting()
        warrior.vitality.addFatigue(5)
        assertEquals(45, warrior.vitality.getCurrentEnergy())

    }
    @Test
    fun shouldReturnCurrentFatigueAfterRecovering() {
        val warrior = KnightTesting()
        warrior.vitality.addFatigue(10)
        warrior.vitality.recoveringEnergy(5)
        assertEquals(5, warrior.vitality.getFatigue)

    }

    @Test
    fun shouldReturnZeroFatigueWhenIsOverRecovering() {
        val warrior = KnightTesting()
        warrior.vitality.addFatigue(20)
        warrior.vitality.recoveringEnergy(30)
        assertEquals(0, warrior.vitality.getFatigue)

    }

}