package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.core.equatable.Equatable

open class ExtraPoints {
    protected var extraPoints: Int = 0


    fun getPoints(): Int {
        return extraPoints
    }
    fun removeSinglePoints() {
        if(extraPoints > 0)
            extraPoints--
    }

    open fun addExtraPoints() {
        extraPoints +=10
    }

    fun customSetExtraPoints(value: Int) {
        if(value > 0) {
        extraPoints += value }
    }

    override fun equals(other: Any?): Boolean {

        return Equatable.getProps<ExtraPoints>(this, other)

    }


}

class SkillPoints : ExtraPoints() {
    override fun addExtraPoints() {
        extraPoints += 1
    }
}