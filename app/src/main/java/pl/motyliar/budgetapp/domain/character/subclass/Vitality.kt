package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.core.equatable.Equatable

class Vitality(val power: Int,
               val strength: Int,
               val intelligence: Int,
               val life: Int,
               val magic: Int,
                val dexterity: Int,
                                ) {
    override fun equals(other: Any?): Boolean {

        return Equatable.getProps<Vitality>(this, other)


    }
}