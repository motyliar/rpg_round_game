package pl.motyliar.budgetapp

import org.junit.Test

import org.junit.Assert.*

import pl.motyliar.budgetapp.domain.character.*
val testName: String = "Test"

class WarriorTests {
    val warrior = Warrior(name = testName,)

    @Test
    fun getCorrectCharacterName() {
        assertEquals(testName, warrior.getCharacterName())
    }
    @Test
    fun addAndCheckIsCorrectExperienceValue() {
        warrior.addExperience(20)
        assertEquals(20, warrior.getExperience())
    }

    @Test
    fun initialExperienceShouldBeZero() {
        assertEquals(0, warrior.getExperience())
    }


}