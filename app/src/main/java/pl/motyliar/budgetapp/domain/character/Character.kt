package pl.motyliar.budgetapp.domain.character
import pl.motyliar.budgetapp.domain.character.subclass.*



abstract class Character(
    val name: String,
    val type: CharacterType,
    val weapon: Weapon,
    val items: Items,
    val vitality: Vitality,
    val experience: Int,
    val money: Int,
    val talisman: Talisman,
    val armorSet: ArmorSet,




    )
 {
     private val deffence: Int = 0
     private val level : CharacterLevel = LevelOne()
}