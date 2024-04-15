package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.core.equatable.Equatable
import pl.motyliar.budgetapp.domain.character.Character
import pl.motyliar.budgetapp.domain.character.subclass.subskill.BuyRequirements
import pl.motyliar.budgetapp.domain.character.subclass.subskill.SkillGrade
import pl.motyliar.budgetapp.domain.character.subclass.subskill.SpecialEffects
import pl.motyliar.budgetapp.domain.character.subclass.subskill.Stun
import pl.motyliar.budgetapp.domain.character.subclass.subskill.UseRequirements
import pl.motyliar.budgetapp.domain.game.Attack

abstract class Skill(
    val grade: SkillGrade,
    name: String,
    val attack: Int,
    useRequirements: UseRequirements,
    val buyRequirements: BuyRequirements,
    val specialEffects: SpecialEffects? = null,
    val cost: Int = 1,

    ) {
    protected val name: String = name
    protected val useRequirements = useRequirements
    abstract fun use(): Attack
    fun canIUse(character: Character): Boolean {
        return _canIUse(character)
    }

    fun canIBuy(character: Character): Boolean {
        return _canIBuy(character)
    }

   fun buy(character: Character) {
       character.skillTree.add(this)
   }

    private fun _canIUse(character: Character): Boolean {

        return character.vitality.strength >= useRequirements.strength &&
                character.vitality.intelligence >= useRequirements.intelligence &&
                character.vitality.dexterity >= useRequirements.dexterity &&
                character.vitality.magic >= useRequirements.magic &&
                character.getCharacterLevel() >= useRequirements.level

    }


   private fun _canIBuy(character: Character): Boolean {
        return buyRequirements.isPossibleToBuy(character) && haveEnoughPoints(character)
    }
    private fun haveEnoughPoints(character: Character) : Boolean {
       return character.skillPoints.getPoints() >= cost
    }

    override fun equals(other: Any?): Boolean {

        return Equatable.getProps<Skill>(this, other)


    }

    override fun toString(): String {
        return "Skill(name: $name)"
    }

}

object FireBall : Skill(
    grade = SkillGrade.FirstGrade,
    name = "Fire Ball",
    attack = 5,
    useRequirements = UseRequirements(level = 1),
    buyRequirements = BuyRequirements(characterLvL = 1,),
    cost = 1,
    specialEffects = Stun()
) {
    override fun use(): Attack {
        return Attack(attack, specialEffects)
    }


}