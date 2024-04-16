package pl.motyliar.budgetapp.domain.character

import pl.motyliar.budgetapp.core.equatable.Equatable
import pl.motyliar.budgetapp.core.equatable.HashCodeGen
import pl.motyliar.budgetapp.domain.character.subclass.*
import pl.motyliar.budgetapp.domain.character.subclass.armors.LeatherJacket
import pl.motyliar.budgetapp.domain.character.subclass.potion.PotionBelt


abstract class Character(
    open var name: String,
    open val weapon: Weapon,
    open val vitality: Vitality,
    var skillTree : MutableList<Skill> = mutableListOf<Skill>(),
    private var potionBelt: PotionBelt,
) {


    val onCharacterEffects: OnCharacterEffects = OnCharacterEffects()
    val getPotionBelt get() = potionBelt

    abstract fun getTotalDefence() : Int
    abstract fun getTotalStrength() : Int

    fun getCharacterName(): String {
        return name
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



