package pl.motyliar.budgetapp.domain.character.subclass.potion

import pl.motyliar.budgetapp.domain.character.Character

sealed class PotionBelt(private var potions: MutableList<Potion?>) {

    data object SmallPotionBelt : PotionBelt(potions = MutableList(4) { null })
    data object MediumPotionBelt : PotionBelt(potions = MutableList(5) { null })

    data object LargePotionBelt : PotionBelt(potions = MutableList(7) { null })

    fun add(potion: Potion, index: Int) {
        potions[index] = potion
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


}





