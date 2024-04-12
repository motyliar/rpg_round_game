package pl.motyliar.budgetapp.domain.character


import org.junit.Assert.*
import org.junit.Test
import pl.motyliar.budgetapp.domain.character.subclass.ExtraPoints

class ExtraPointsTest {

    val extraPoint: ExtraPoints = ExtraPoints()

    @Test
    fun checkInitialExtraPoints() {
        assertEquals(0, extraPoint.getPoints())
    }
    @Test
    fun removePointsWhenExtraPointsIsZero() {
        extraPoint.removeSinglePoints()
        assertEquals(0, extraPoint.getPoints())
    }

    @Test
    fun removePointsWhenExtraPointsIsGreatherThenZero() {
        extraPoint.customSetExtraPoints(10)
        extraPoint.removeSinglePoints()
        assertEquals(9, extraPoint.getPoints())
    }

    @Test
    fun checkIsAddExtraPoints() {
        extraPoint.addExtraPoints()
        assertEquals(10, extraPoint.getPoints())
    }
    @Test
    fun checkIsAddValueWhenIsMoreThenZero() {
        extraPoint.customSetExtraPoints(10)
        assertEquals(10, extraPoint.getPoints())
    }
    @Test
    fun checkIsZeroWhenValueIsLessThenZero() {
        extraPoint.customSetExtraPoints(-10)
        assertEquals(0, extraPoint.getPoints())
    }
}