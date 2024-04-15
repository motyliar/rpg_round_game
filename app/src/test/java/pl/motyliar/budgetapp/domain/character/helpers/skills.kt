package pl.motyliar.budgetapp.domain.character.helpers

import pl.motyliar.budgetapp.domain.character.subclass.FireBall
import pl.motyliar.budgetapp.domain.character.subclass.Skill
import pl.motyliar.budgetapp.domain.character.subclass.subskill.BuyRequirements
import pl.motyliar.budgetapp.domain.character.subclass.subskill.SkillGrade
import pl.motyliar.budgetapp.domain.character.subclass.subskill.Stun
import pl.motyliar.budgetapp.domain.character.subclass.subskill.UseRequirements
import pl.motyliar.budgetapp.domain.game.Attack

object FireBallSecondTest : Skill(
    grade = SkillGrade.SecondGrade,
    name = "Fire Ball",
    attack = 5,
    useRequirements = UseRequirements(level = 1, strength = 30),
    buyRequirements = BuyRequirements(characterLvL = 1, skill = FireBall, grade = SkillGrade.FirstGrade),
    cost = 1,
    specialEffects = Stun()
) {
    override fun use(): Attack {
        return Attack(attack, specialEffects)
    }


}