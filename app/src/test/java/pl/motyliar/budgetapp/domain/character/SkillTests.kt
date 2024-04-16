package pl.motyliar.budgetapp.domain.character


import org.junit.Test
import org.junit.Assert.*
import pl.motyliar.budgetapp.domain.character.helpers.FireBallSecondTest
import pl.motyliar.budgetapp.domain.character.helpers.WarriorTest
import pl.motyliar.budgetapp.domain.character.subclass.FireBall
import pl.motyliar.budgetapp.domain.character.subclass.Skill
import pl.motyliar.budgetapp.domain.character.subclass.subskill.BuyRequirements
import pl.motyliar.budgetapp.domain.character.subclass.subskill.SkillGrade
import pl.motyliar.budgetapp.domain.character.subclass.subskill.Stun
import pl.motyliar.budgetapp.domain.character.subclass.subskill.UseRequirements
import pl.motyliar.budgetapp.domain.game.Attack


class SkillTests {
    var warrior = WarriorTest()
    val fireballsecond = FireBallSecondTest

    @Test
    fun checkIsPossibleToBuyNewSkillShouldReturnTrue() {
        warrior.skillPoints.addExtraPoints()
        warrior.skillTree.add(FireBall)
        val possibleToBuy = fireballsecond.canIBuy(warrior)
        assertTrue(possibleToBuy)
    }
    @Test
    fun checkIsPossibleToBuyNewSkillShouldReturnFalse() {
        val possibleToBuy = fireballsecond.canIBuy(warrior)
        assertFalse(possibleToBuy)
    }

    @Test
    fun isSkillPossibleToUseShouldReturnTrue() {
        warrior.vitality.strength = 32
        val possibleToUse = fireballsecond.canIUse(warrior)
        assertTrue(possibleToUse)
    }

    @Test
    fun isSkillPossibleToUseShouldReturnFalse() {
        val possibleToUse = fireballsecond.canIUse(warrior)
        assertFalse(possibleToUse)
    }

    @Test
    fun toStringShouldReturnTrueWhenCorrect() {
        val name = "Skill(name: Fire Ball)"
        assertEquals(name, fireballsecond.toString())


    }

    @Test
    fun toStringShouldReturnTrueWhenIncorrect() {
        val name = "Skill(name: Fire)"
        assertNotEquals(name, fireballsecond.toString())

    }

    @Test
    fun shouldReturnCorrectInitValues() {
        assertEquals("Fire Ball", fireballsecond.getSkillName())
        assertEquals(5, fireballsecond.attack)
        assertEquals(SkillGrade.SecondGrade, fireballsecond.grade)
    }

    @Test
    fun shouldReturnAttackObject() {
        val attack = fireballsecond.use()
        assertTrue(attack is Attack)
    }

    @Test
    fun handlingCorrectAttackValues() {
        val attack = fireballsecond.use()
        assertEquals(5, attack.attackPower)
        assertTrue(attack.specialEffects is Stun)
    }







}