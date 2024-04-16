package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.domain.character.Character


private const val SMALL_POTION_POINTS = 10
private const val MEDIUM_POTION_POINTS = 30
private const val LARGE_POTION_POINTS = 50
abstract class Potion(
    val potionSize: PotionSize,
    name: String, price: Int, type: ItemType = ItemType.POTION) : Item(name, price, type,) {
    protected val recoveryPoints: Int = when(potionSize) {
        PotionSize.SmallPotion -> SMALL_POTION_POINTS
        PotionSize.MediumPotion -> MEDIUM_POTION_POINTS
        PotionSize.LargePotion -> LARGE_POTION_POINTS

    }

    abstract fun recovering(character: Character)
}

sealed class PotionSize {
    data object SmallPotion : PotionSize()
    data object MediumPotion: PotionSize()
    data object LargePotion: PotionSize()

}
class HealthPotion(size: PotionSize) : Potion(potionSize = size, name = "of health", price = 100) {
    override fun recovering(character: Character) {
        character.vitality.recoveringHealth(recoveryPoints)
    }
}