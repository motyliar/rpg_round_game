package pl.motyliar.budgetapp.core.equatable

import org.junit.Assert.*
import org.junit.Test
import pl.motyliar.budgetapp.domain.character.Warrior
import pl.motyliar.budgetapp.core.equatable.Equatable
import pl.motyliar.budgetapp.domain.character.Character


class Person(
   val name: String = "Bogdan",
   val isCheck: Boolean? = null,
   val surname: String = "Hejho",
   val warrior: Warrior = Warrior()

)

class EquatableTest {
    val warrior1 = Warrior()
    val warrior2 = Warrior()
    @Test
    fun checkIsThisSameWarrior() {


        assertTrue(Equatable.getProps<Character>(warrior1, warrior2))
    }

    @Test
    fun checkWarriorAndReturnFalse() {
        warrior1.money = 120
        assertFalse(Equatable.getProps<Character>(warrior1, warrior2))
    }

    @Test
    fun checkSinglePersonClassAndReturnTrue() {
        val person = Person()
        val person2 = Person()

        assertTrue(Equatable.getProps<Person>(person, person2))
    }

    @Test
    fun checkSinglePersonClassAndReturnFalse() {
        val person = Person()
        val person2 = Person(name = "Heniek")

        assertFalse(Equatable.getProps<Person>(person, person2))
    }









}