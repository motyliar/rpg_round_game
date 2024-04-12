package pl.motyliar.budgetapp.domain.player

import pl.motyliar.budgetapp.domain.character.*

abstract class Player(character: Character) {
    abstract fun attack()

}

