package pl.motyliar.budgetapp.domain.character.subclass

class CharacterLevel() {
    fun getLevel(experience: Int): Int {
        when(experience) {
          in  0 ..99-> return 1
            in 100 .. 199 ->return 2
            in 200 .. 299 -> return 3
            else -> return 1
        }

    }
}


