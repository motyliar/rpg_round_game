package pl.motyliar.budgetapp.domain.character


import org.junit.Assert.*
import org.junit.Test
import pl.motyliar.budgetapp.domain.character.subclass.ExtraPoints

class ExtraPointsTest {

    val extraPoint: ExtraPoints = ExtraPoints()

    @Test
    fun checkInitialExtraPoints() {
        assertEquals(0, extraPoint.getExtraPoints())
    }
    @Test
    fun removePointsWhenExtraPointsIsZero() {
        extraPoint.removeSinglePoints()
        assertEquals(0, extraPoint.getExtraPoints())
    }

    @Test
    fun removePointsWhenExtraPointsIsGreatherThenZero() {
        extraPoint.setExtraPoints(10)
        extraPoint.removeSinglePoints()
        assertEquals(9, extraPoint.getExtraPoints())
    }

    @Test
    fun checkIsAddExtraPoints() {
        extraPoint.addExtraPoints()
        assertEquals(10, extraPoint.getExtraPoints())
    }
    @Test
    fun checkIsAddValueWhenIsMoreThenZero() {
        extraPoint.setExtraPoints(10)
        assertEquals(10, extraPoint.getExtraPoints())
    }
    @Test
    fun checkIsZeroWhenValueIsLessThenZero() {
        extraPoint.setExtraPoints(-10)
        assertEquals(0, extraPoint.getExtraPoints())
    }
}