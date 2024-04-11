package pl.motyliar.budgetapp.domain.character

import org.junit.Test
import org.junit.Assert.*
import pl.motyliar.budgetapp.domain.character.subclass.ItemType
import pl.motyliar.budgetapp.domain.character.subclass.Talisman
import pl.motyliar.budgetapp.domain.character.subclass.TalismanKind

class TalismanTests {
    val talisman: Talisman = Talisman(name = "of Power", price = 10, extraPoints = 10, talismanKind = TalismanKind.POWER, type = ItemType.TALISMAN )

    @Test
    fun getTalismanName() {
        assertEquals("Talisman of Power", talisman.getFullName())
    }

    @Test
    fun getPowerOfTalismanByTalismanKind() {
        assertEquals(10, talisman.getExtraPoints(TalismanKind.POWER))
    }

    @Test
    fun shouldReturnZeroWhenTalismanKindIsNotEqual() {
        assertEquals(0, talisman.getExtraPoints(TalismanKind.MAGIC))
    }
}