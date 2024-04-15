package pl.motyliar.budgetapp.domain.character.subclass.subskill

data class UseRequirements(
    val level: Int,
    val strength: Int = 0,
    val intelligence: Int = 0,
    val magic: Int = 0,
    val dexterity: Int = 0
)
