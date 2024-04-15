package pl.motyliar.budgetapp.domain.character

import org.junit.Assert.*
import org.junit.Test
class VitalityTests {

    val warrior: Warrior = Warrior()

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
}