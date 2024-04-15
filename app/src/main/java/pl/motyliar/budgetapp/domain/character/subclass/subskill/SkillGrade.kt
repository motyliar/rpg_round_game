package pl.motyliar.budgetapp.domain.character.subclass.subskill

import pl.motyliar.budgetapp.domain.character.subclass.Skill

sealed class SkillGrade() {
   data object FirstGrade : SkillGrade()
     data object SecondGrade : SkillGrade()
     data object ThirdGrade : SkillGrade()


}