package pl.motyliar.budgetapp.domain.character

import pl.motyliar.budgetapp.core.equatable.Equatable
import pl.motyliar.budgetapp.core.equatable.HashCodeGen
import pl.motyliar.budgetapp.domain.character.subclass.*
import pl.motyliar.budgetapp.domain.character.subclass.armors.LeatherJacket


abstract class Character(
    open var name: String,
    open val type: CharacterType,
    open val weapon: Weapon,
    open val items: Items = Items(),
    open val vitality: Vitality,
    private var experience: Int = 0,
    var money: Int = 100,
    var talisman: Talisman? = null,
    open val armorSet: ArmorSet,
    var skillTree : MutableList<Skill> = mutableListOf<Skill>()
) {
    private var _characterLevel: Int = 1
    private var _extraPoints: ExtraPoints = ExtraPoints()
    private var _skillPoints: ExtraPoints = SkillPoints()
    val extraPoints: ExtraPoints = _extraPoints
    val skillPoints: ExtraPoints = _skillPoints
    val onCharacterEffects: OnCharacterEffects = OnCharacterEffects()



    fun getCharacterName(): String {
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
        return vitality.strength + weapon.power + talismanPower
    }

    fun getTotalDefence(): Int {
        val armorDefence = armorSet.getTotalDefence()
        val weaponDefence = weapon.defence
        val talismanDefence = talisman?.getExtraPoints(TalismanKind.DEFENCE) ?: 0
        return armorDefence + weaponDefence + talismanDefence
    }

    fun getCharacterLevel(): Int {
        return _characterLevel
    }
   private fun updateCharacterLevel(): Boolean {
        val level: Int = CharacterLevel().getLevel(experience)
        if(level > _characterLevel) {
            _characterLevel = level
            return true
        }
       return false

    }

    fun updateCharacter() {
        if(updateCharacterLevel()) {
            extraPoints.addExtraPoints()
            skillPoints.addExtraPoints()
        }

    }

    fun buySkill(skill: Skill) {
        if(skill.canIBuy(this)) {
            skillTree.add(skill)
        }
    }

    override fun equals(other: Any?): Boolean {
        return Equatable.getProps<Character>(this, other)
    }





}

class Warrior(
    override var name: String = "Bogdan",
    override val type: CharacterType = CharacterType.Warrior,
    override val weapon: Weapon = Sword(),
    override val vitality: Vitality = Vitality(
        energy = 10,
        strength = 10,
        intelligence = 10,
        life = 50,
        magic = 10,
        dexterity = 10
    ),
    override val armorSet: ArmorSet = ArmorSet(chest = LeatherJacket())


) : Character(
    name = name,
    type = type, weapon = weapon, vitality = vitality, armorSet = armorSet

) {



}

