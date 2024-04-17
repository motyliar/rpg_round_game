package pl.motyliar.budgetapp.domain.character.subclass.potion

import pl.motyliar.budgetapp.domain.character.Character
import pl.motyliar.budgetapp.domain.character.subclass.Item
import pl.motyliar.budgetapp.domain.character.subclass.ItemType


private const val SMALL_POTION_POINTS = 10
private const val MEDIUM_POTION_POINTS = 30
private const val LARGE_POTION_POINTS = 50

private const val SMALL_POTION_PRICE = 40
private const val MEDIUM_POTION_PRICE = 70
private const val LARGE_POTION_PRICE = 100

abstract class Potion(
    val potionSize: PotionSize,
    name: String, price: Int = when (potionSize) {
        PotionSize.SmallPotion -> SMALL_POTION_PRICE
        PotionSize.MediumPotion -> MEDIUM_POTION_PRICE
        PotionSize.LargePotion -> LARGE_POTION_PRICE
    }, type: ItemType = ItemType.POTION
) : Item(name, price, type) {
    protected val recoveryPoints: Int = when (potionSize) {
        PotionSize.SmallPotion -> SMALL_POTION_POINTS
        PotionSize.MediumPotion -> MEDIUM_POTION_POINTS
        PotionSize.LargePotion -> LARGE_POTION_POINTS

    }

    abstract fun recovering(character: Character)

    override fun toString(): String {
        return "Potion: $name, price: $price"
    }
}

sealed class PotionSize {
    data object SmallPotion : PotionSize()
    data object MediumPotion : PotionSize()
    data object LargePotion : PotionSize()

}

class HealthPotion(size: PotionSize) :
    Potion(potionSize = size, name = "of health") {
    override fun recovering(character: Character) {
        character.vitality.recoveringHealth(recoveryPoints)
    }
}

class EnergyPotion(size: PotionSize) :
    Potion(potionSize = size, name = "of energy") {
    override fun recovering(character: Character) {
        character.vitality.recoveringEnergy(recoveryPoints)
    }
}