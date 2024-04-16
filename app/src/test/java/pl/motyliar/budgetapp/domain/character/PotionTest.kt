package pl.motyliar.budgetapp.domain.character

import org.junit.Assert.*
import org.junit.Test
import pl.motyliar.budgetapp.domain.character.helpers.WarriorTest
import pl.motyliar.budgetapp.domain.character.subclass.potion.EnergyPotion
import pl.motyliar.budgetapp.domain.character.subclass.potion.HealthPotion
import pl.motyliar.budgetapp.domain.character.subclass.potion.PotionSize

class PotionTest {


    @Test
    fun price_setCorrectPrice_returnCorrectPrice() {

        //given
        val potion = HealthPotion(PotionSize.SmallPotion)
        // when
        val potionPrice = potion.price
        // then
        assertEquals(40, potionPrice)

    }

    @Test
    fun recovering_whenWarriorUseEnergyPotion_thenReturnCorrectEnergy() {
        //given
        val warrior = WarriorTest()
        val potion = EnergyPotion(PotionSize.SmallPotion)
        //when
        warrior.vitality.addFatigue(20)
        potion.recovering(warrior)
        //then
        assertEquals(10, warrior.vitality.getCurrentEnergy())

    }
}