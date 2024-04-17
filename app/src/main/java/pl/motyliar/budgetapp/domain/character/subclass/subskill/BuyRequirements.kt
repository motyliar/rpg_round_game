package pl.motyliar.budgetapp.domain.character.subclass.subskill

import pl.motyliar.budgetapp.domain.character.Character
import pl.motyliar.budgetapp.domain.character.subclass.CharacterLevel
import pl.motyliar.budgetapp.domain.character.subclass.Skill
import pl.motyliar.budgetapp.domain.character.warriors.Warriors

class BuyRequirements(
    val characterLvL: Int,
    private val grade: SkillGrade? = null,
    private val skill: Skill? = null,
) {

    fun isPossibleToBuy(character: Warriors): Boolean {
        return haveSkillWithEnoughGrade(character)

    }

    private fun haveSkillWithEnoughGrade(character: Warriors): Boolean {
        if (skill == null) {
            return true
        } else {
            val foundSkill = character.skillTree.find { it == skill }
            return foundSkill?.grade == grade && haveSkill(character)
        }
    }

    private fun haveSkill(character: Warriors): Boolean {
        return skill == null || character.skillTree.contains(skill) && haveEnoughLevel(character)


    }

    private fun haveEnoughLevel(character: Warriors): Boolean {
        return character.getCharacterLevel() >= characterLvL
    }
}