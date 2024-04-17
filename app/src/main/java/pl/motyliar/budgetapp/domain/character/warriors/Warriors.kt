package pl.motyliar.budgetapp.domain.character.warriors

import pl.motyliar.budgetapp.domain.character.Character
import pl.motyliar.budgetapp.domain.character.subclass.ArmorSet
import pl.motyliar.budgetapp.domain.character.subclass.CharacterLevel
import pl.motyliar.budgetapp.domain.character.subclass.ExtraPoints
import pl.motyliar.budgetapp.domain.character.subclass.Items
import pl.motyliar.budgetapp.domain.character.subclass.Skill
import pl.motyliar.budgetapp.domain.character.subclass.SkillPoints
import pl.motyliar.budgetapp.domain.character.subclass.Talisman
import pl.motyliar.budgetapp.domain.character.subclass.TalismanKind
import pl.motyliar.budgetapp.domain.character.subclass.Vitality
import pl.motyliar.budgetapp.domain.character.subclass.Weapon
import pl.motyliar.budgetapp.domain.character.subclass.potion.PotionBelt

abstract class Warriors(
    name: String,
    open val items: Items = Items(),
    open val armorSet: ArmorSet,
    vitality: Vitality,
    weapon: Weapon,
    potionBelt: PotionBelt,
    ) : Character(name = name, vitality = vitality, weapon = weapon, potionBelt = potionBelt,) {
    private var experience: Int = 0

    private var _characterLevel: Int = 1
    private var _extraPoints: ExtraPoints = ExtraPoints()
    private var _skillPoints: ExtraPoints = SkillPoints()
    val extraPoints: ExtraPoints = _extraPoints
    val skillPoints: ExtraPoints = _skillPoints
    var talisman: Talisman? = null

    override fun getTotalDefence(): Int {
        val armorDefence = armorSet.getTotalDefence()
        val weaponDefence = weapon.defence
        val talismanDefence = talisman?.getExtraPoints(TalismanKind.DEFENCE) ?: 0
        return armorDefence + weaponDefence + talismanDefence
    }

    override fun getTotalStrength(): Int {
        val talismanPower = talisman?.getExtraPoints(TalismanKind.POWER) ?: 0
        return vitality.strength + weapon.power + talismanPower
    }


    fun addExperience(value: Int) {
        experience += value
    }

    fun getExperience(): Int {
        return experience
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


}