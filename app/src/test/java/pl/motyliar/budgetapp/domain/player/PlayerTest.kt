package pl.motyliar.budgetapp.domain.player


import org.junit.Test
import org.junit.Assert.*
import pl.motyliar.budgetapp.domain.character.Warrior
import pl.motyliar.budgetapp.domain.character.subclass.CharacterType

class PlayerTest {
    var warrior = Warrior()
    var computer: Computer = Computer(warrior)
    var human: Human = Human(warrior)

    @Test
    fun checkIsIstanceOfPlayer() {
        assertTrue(computer is Player)
        assertTrue(human is Player)
    }
}