package pl.motyliar.budgetapp.domain.character.subclass.potion

import pl.motyliar.budgetapp.domain.character.Character

sealed class PotionBelt(private var potions: MutableList<Potion?>) {

    data object SmallPotionBelt : PotionBelt(potions = MutableList(4) { null })
    data object MediumPotionBelt : PotionBelt(potions = MutableList(5) { null })

    data object LargePotionBelt : PotionBelt(potions = MutableList(7) { null })

    fun add(potion: Potion, index: Int) {
        if (potions[index] == null) {
            potions[index] = potion
        } else {
            addToNextEmpty(potion)


        }
    }

    fun remove(index: Int) {
        potions[index] = null
    }

    fun use(index: Int, character: Character) {
        potions[index]!!.recovering(character)
        remove(index)
    }

    fun show(): MutableList<Potion?> {
        return potions
    }

    val size: Int
        get() = potions.size

    fun findEmptySpace(): Int {
        val index = potions.indexOfFirst { it == null }

        if (index != -1) {
            return index
        } else {
            return -1
        }
    }
    private fun addToNextEmpty(potion: Potion) {
        val emptyIndex = findEmptySpace()
        if(emptyIndex != -1) {
            potions[emptyIndex] = potion
        }

    }

    override fun toString(): String {
        return "Potions: $potions"
    }


}





