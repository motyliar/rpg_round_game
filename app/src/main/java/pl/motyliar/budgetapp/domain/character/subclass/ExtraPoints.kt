package pl.motyliar.budgetapp.domain.character.subclass

class ExtraPoints {
    private var extraPoints: Int = 0


    fun getExtraPoints(): Int {
        return extraPoints
    }
    fun removeSinglePoints() {
        if(extraPoints > 0)
            extraPoints--
    }

    fun addExtraPoints() {
        extraPoints +=10
    }

    fun setExtraPoints(value: Int) {
        extraPoints += value
    }


}