package pl.motyliar.budgetapp.domain.character

import org.junit.Assert.*
import org.junit.Test
import pl.motyliar.budgetapp.domain.character.helpers.KnightTest

class CharacterTests {
    val knight: Character = KnightTest
    @Test
    fun getName_call_returnCorrectName() {
        //given
        val name = "Knight"
        //when
        val result = knight.getCharacterName()
        //then
        assertEquals(name, result)
    }

}