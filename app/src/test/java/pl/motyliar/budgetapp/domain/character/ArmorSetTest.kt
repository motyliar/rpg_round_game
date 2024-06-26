package pl.motyliar.budgetapp.domain.character

import org.junit.Test
import org.junit.Assert.*
import pl.motyliar.budgetapp.domain.character.subclass.ArmorSet
import pl.motyliar.budgetapp.domain.character.subclass.armors.LeatherBoots
import pl.motyliar.budgetapp.domain.character.subclass.armors.*



class ArmorSetTest {

    val warrior: Character = Warrior()
    val armorSetTest: ArmorSet = ArmorSet(chest = LeatherJacket(), boots = LeatherBoots())


   
    @Test
    fun shouldBeBootsInArmorSet() {
        val newBoots = LeatherBoots()
        val copiedArmorSet =  warrior.armorSet.copyWith(boots = newBoots)

        assertEquals(armorSetTest, copiedArmorSet)

    }

    @Test
    fun shouldReturnFalseWhenCopareArmorSet() {
        assertFalse(warrior.armorSet == armorSetTest)
    }
    @Test
    fun shouldReturnTrueWhenCompareArmoreSet() {
        val newBoots = LeatherBoots()
        val copiedArmorSet =  warrior.armorSet.copyWith(boots = newBoots)
        assertTrue(armorSetTest == copiedArmorSet)
    }

    @Test
    fun shouldReturnArmorSetFullDefence() {
        val newBoots = LeatherBoots()
        val copiedArmorSet =  warrior.armorSet.copyWith(boots = newBoots)
        assertEquals(44, copiedArmorSet.getTotalDefence())
    }


}