package pl.motyliar.budgetapp.domain.character

import org.junit.Assert.*
import org.junit.Test
import pl.motyliar.budgetapp.domain.character.helpers.KnightTest

class VitalityTests {

    val warrior = KnightTest

    @Test
    fun getInitialLife() {
        assertEquals(50, warrior.vitality.getCurrentLife())
    }

    @Test
    fun addLifeAndGetActualLife() {
        warrior.vitality.addLife(20)
        assertEquals(70, warrior.vitality.getCurrentLife())
    }

    @Test
    fun getCurrentLifeAfterDamages() {
        warrior.vitality.addLife(10)
        warrior.vitality.addDamages(20)

        assertEquals(40, warrior.vitality.getCurrentLife())
    }

    @Test
    fun shouldAddIntelligenceValue() {
        warrior.vitality.addIntelligence(10)

        assertEquals(20, warrior.vitality.intelligence)
    }

    @Test
    fun shouldReturnCurrentDamageValue() {
        warrior.vitality.addDamages(20)
        assertEquals(20, warrior.vitality.getDamage)
    }
    @Test
    fun shouldReturnCurrentDamageAfterRecovering() {
        warrior.vitality.addDamages(20)
        warrior.vitality.recoveringHealth(10)
        assertEquals(10, warrior.vitality.getDamage)

    }

    @Test
    fun shouldReturnZeroDamageWhenIsOverRecovering() {
        warrior.vitality.addDamages(20)
        warrior.vitality.recoveringHealth(30)
        assertEquals(0, warrior.vitality.getDamage)

    }

    @Test
    fun shouldReturnCurrentFatigueValue() {
        warrior.vitality.addFatigue(20)
        assertEquals(20, warrior.vitality.getFatigue)
    }
    @Test
    fun shouldReturnCurrentEnergy() {
        warrior.vitality.addFatigue(5)
        assertEquals(15, warrior.vitality.getCurrentEnergy())

    }
    @Test
    fun shouldReturnCurrentFatigueAfterRecovering() {
        warrior.vitality.addFatigue(10)
        warrior.vitality.recoveringEnergy(5)
        assertEquals(5, warrior.vitality.getFatigue)

    }

    @Test
    fun shouldReturnZeroFatigueWhenIsOverRecovering() {
        warrior.vitality.addFatigue(20)
        warrior.vitality.recoveringEnergy(30)
        assertEquals(0, warrior.vitality.getFatigue)

    }

}