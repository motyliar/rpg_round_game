package pl.motyliar.budgetapp.domain.character


import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import pl.motyliar.budgetapp.domain.character.Warrior
import pl.motyliar.budgetapp.domain.character.subclass.CharacterType
import pl.motyliar.budgetapp.domain.character.subclass.ItemType
import pl.motyliar.budgetapp.domain.character.subclass.Talisman
import pl.motyliar.budgetapp.domain.character.subclass.TalismanKind

val testName: String = "Test"

class WarriorTests {
    val warrior = Warrior(name = testName)

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

    @Test
    fun shouldGetTotalPowerWithoutTalisman() {
        assertEquals(30, warrior.getTotalPower())
    }

    @Test
    fun shouldGetTotalPowerWithTalisman() {
        val powerTalisman = Talisman(
            name = "of Power",
            type = ItemType.TALISMAN,
            extraPoints = 10,
            price = 10,
            talismanKind = TalismanKind.POWER
        )
        warrior.talisman = powerTalisman

        assertEquals(40, warrior.getTotalPower())
    }

    @Test
    fun shouldGetTotalPowerWithNoPowerTalisman() {
        val magicTalisman = Talisman(
            name = "of Power",
            type = ItemType.TALISMAN,
            extraPoints = 10,
            price = 10,
            talismanKind = TalismanKind.MAGIC
        )
        warrior.talisman = magicTalisman
        assertEquals(30, warrior.getTotalPower())
    }

    @Test
    fun shouldGetTotalDefence() {
        assertEquals(30, warrior.getTotalDefence())
    }
    @Test
    fun shouldGetTotalDefenceWithDefenceTalisman() {
        val defenceTalisman = Talisman(
            name = "of Defence",
            type = ItemType.TALISMAN,
            extraPoints = 10,
            price = 10,
            talismanKind = TalismanKind.DEFENCE
        )
        warrior.talisman = defenceTalisman
        assertEquals(40, warrior.getTotalDefence())
    }
    @Test
    fun shouldReturnExtraPoints() {
        warrior.extraPoints.addExtraPoints()

        assertEquals(10, warrior.extraPoints.getExtraPoints())
    }
    @Test
    fun afterDecrementShouldReturnLessExtraPoints() {
        warrior.extraPoints.addExtraPoints()
        warrior.extraPoints.removeSinglePoints()
        warrior.extraPoints.addExtraPoints()
        warrior.extraPoints.removeSinglePoints()

        assertEquals(18, warrior.extraPoints.getExtraPoints())
    }
}