package pl.motyliar.budgetapp.domain.character

import org.junit.Assert.*
import org.junit.Test
import pl.motyliar.budgetapp.domain.character.helpers.KnightTest
import pl.motyliar.budgetapp.domain.character.subclass.potion.HealthPotion
import pl.motyliar.budgetapp.domain.character.subclass.potion.Potion
import pl.motyliar.budgetapp.domain.character.subclass.potion.PotionBelt
import pl.motyliar.budgetapp.domain.character.subclass.potion.PotionSize

class PotionBeltTest {

    val potionBelt = PotionBelt.SmallPotionBelt()
    val potionBeltMedium = PotionBelt.MediumPotionBelt()
    val potionBeltLarge = PotionBelt.LargePotionBelt()
    val potion = HealthPotion(PotionSize.SmallPotion)
    @Test
    fun size_whenSmallPotionBelt_returnCorrectSize() {
        //given

        //when
        val sizeSmall = potionBelt.size
        val sizeMedium = potionBeltMedium.size
        val sizeLarge = potionBeltLarge.size
        //then
        assertEquals(4, sizeSmall)
        assertEquals(5, sizeMedium)
        assertEquals(7, sizeLarge)
    }

    @Test
    fun show_whenShow_thenReturnCorrectReference() {

        //then
        assertTrue(potionBelt.show() is MutableList<Potion?>)
    }

    @Test
    fun add_whenAddPotion_returnIndexIsNtNull() {
        //given
        val potion = HealthPotion(PotionSize.SmallPotion)
        val index = 0
        //when
        potionBelt.add(potion, index)
        val potions = potionBelt.show()
        //then
        assertTrue(potions[index] != null)
    }

    @Test
    fun remove_whenRemovePotion_indexOfPotionIsNull() {
        //given
        val potion = HealthPotion(PotionSize.SmallPotion)
        val index = 0
        //when
        potionBelt.add(potion, index)
        potionBelt.remove(index)
        val potions = potionBelt.show()
        //then
        assertTrue(potions[index] == null)
    }
    @Test
    fun use_whenUsePotion_indexOfPotionIsNull() {
        //given
        val potion = HealthPotion(PotionSize.SmallPotion)
        val warrior = KnightTest
        val index = 0
        //when
        potionBelt.add(potion, index)
        potionBelt.use(index, warrior)
        val potions = potionBelt.show()

        //then
        assertTrue(potions[index] == null)
    }

    @Test
    fun findEmptySpace_whenCall_returnFirstNullIndexZero() {
        //when
        val result = potionBelt.findEmptySpace()
        //then
        assertEquals(0, result)
    }
    @Test
    fun findEmptySpace_whenAddPotionAndCall_returnFirstNullIndexOne() {
        //given
        val potionBeltSmall = PotionBelt.SmallPotionBelt()
        //when
        potionBeltSmall.add(potion, 0)
        println(potionBelt.show().toString())
        val result = potionBeltSmall.findEmptySpace()
        //then
        assertEquals(1, result)
    }

    @Test
    fun add_whenAddToOccupied_thenAddToNextFree() {
        //given
        val potionBeltSmall = PotionBelt.SmallPotionBelt()
        //when
        potionBeltSmall.add(potion, 0)
        potionBeltSmall.add(potion, 0)
        println(potionBelt.show())
        //then
        assertTrue(potionBeltSmall.show()[0] != null)
        assertTrue(potionBeltSmall.show()[1] != null)
        assertTrue(potionBeltSmall.show()[2] == null)
    }

    @Test
    fun add_whenAddToFullBelt_thenNothingChange() {
        //given
        for(i in 0 .. 3) {
            potionBelt.add(potion, 0)
        }
        val before = potionBelt.show().hashCode()
        //when
        potionBelt.add(potion, 0)
        val after = potionBelt.show().hashCode()
        //then
        assertTrue(before == after)
    }


}