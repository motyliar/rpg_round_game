package pl.motyliar.budgetapp.domain.character
import pl.motyliar.budgetapp.domain.character.subclass.*
import pl.motyliar.budgetapp.domain.character.subclass.armors.LeatherJacket


abstract class Character(
    open var name: String,
    open val type: CharacterType,
    open val weapon: Weapon,
    open val items: Items = Items(),
    open val vitality: Vitality,
    private var experience: Int = 0,
    val money: Int = 100,
    var talisman: Talisman? = null,
    open val armorSet: ArmorSet,
    )
 {

     private var _extraPoints: ExtraPoints = ExtraPoints()
     val extraPoints: ExtraPoints = _extraPoints

     private val level : CharacterLevel = LevelOne()
     fun getCharacterName() : String {
         return name
     }
     fun addExperience(value: Int) {
         experience += value
     }

     fun getExperience(): Int {
         return experience
     }
     fun getTotalPower(): Int {
         val talismanPower = talisman?.getExtraPoints(TalismanKind.POWER) ?: 0
         return vitality.power + weapon.power + talismanPower
     }

     fun getTotalDefence(): Int {
         val armorDefence = armorSet.getTotalDefence()
         val weaponDefence = weapon.defence
         val talismanDefence = talisman?.getExtraPoints(TalismanKind.DEFENCE) ?: 0
         return armorDefence + weaponDefence + talismanDefence
     }

}

class Warrior(
    override var name: String = "Bogdan",
    override val type: CharacterType = CharacterType.Warrior,
    override val weapon: Weapon = Sword(),
    override val vitality: Vitality = Vitality(power = 10, strength = 10, intelligence = 10, life = 50, magic = 10, dexterity = 10),
    override val armorSet: ArmorSet = ArmorSet(chest = LeatherJacket())


) : Character(name = name,
    type = type, weapon = weapon, vitality = vitality, armorSet = armorSet

) {

}

