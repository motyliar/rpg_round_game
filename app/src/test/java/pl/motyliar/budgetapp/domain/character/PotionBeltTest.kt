package pl.motyliar.budgetapp.domain.character

import org.junit.Assert.*
import org.junit.Test
import pl.motyliar.budgetapp.domain.character.helpers.WarriorTest
import pl.motyliar.budgetapp.domain.character.subclass.potion.HealthPotion
import pl.motyliar.budgetapp.domain.character.subclass.potion.Potion
import pl.motyliar.budgetapp.domain.character.subclass.potion.PotionBelt
import pl.motyliar.budgetapp.domain.character.subclass.potion.PotionSize

class PotionBeltTest {

    val potionBelt = PotionBelt.SmallPotionBelt
    val potionBeltMedium = PotionBelt.MediumPotionBelt
    val potionBeltLarge = PotionBelt.LargePotionBelt
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
        val warrior = WarriorTest()
        val index = 0
        //when
        potionBelt.add(potion, index)
        potionBelt.use(index, warrior)
        val potions = potionBelt.show()

        //then
        assertTrue(potions[index] == null)
    }
}