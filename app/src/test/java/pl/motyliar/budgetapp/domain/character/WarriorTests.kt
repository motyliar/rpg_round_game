package pl.motyliar.budgetapp.domain.character


import org.junit.Assert
import org.junit.Test
import pl.motyliar.budgetapp.domain.character.Warrior
import pl.motyliar.budgetapp.domain.character.subclass.CharacterType

val testName: String = "Test"

class WarriorTests {
    val warrior = Warrior(name = testName,)

    @Test
    fun getCorrectCharacterName() {
        Assert.assertEquals(testName, warrior.getCharacterName())
    }
    @Test
    fun addAndCheckIsCorrectExperienceValue() {
        warrior.addExperience(20)
        Assert.assertEquals(20, warrior.getExperience())
    }

    @Test
    fun initialExperienceShouldBeZero() {
        Assert.assertEquals(0, warrior.getExperience())
    }
    }