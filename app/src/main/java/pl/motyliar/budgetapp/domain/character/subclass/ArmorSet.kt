package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.domain.character.subclass.armors.*

data class ArmorSet(
    val gloves: Gloves? = null,
    val pants: Pants? = null,
    val chest: Chest? = null,
    val head: Head? = null,
    val boots: Boots? = null,
    val shield: Shield? = null
) {

}