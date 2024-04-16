package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.core.equatable.Equatable

class Vitality(
    var strength: Int,
    var intelligence: Int,
    private var life: Int,
    val magic: Int,
    val dexterity: Int,
    private var energy: Int,


    ) {

    private var fatigue: Int = 0
    val getFatigue get() = fatigue
    private var damages: Int = 0
    val getDamage get() = damages


    val characterLife = life
    val characterEnergy = energy
    val addLife: (Int) -> Unit = { this.life += it }
    val addIntelligence: (Int) -> Unit = { this.intelligence += it }

    fun recoveringHealth(value: Int) {
        if (getCurrentLife() + value >= characterLife) {
            damages = 0
        } else {
            damages -= value
        }
    }

    fun recoveringEnergy(value: Int) {
        if (getCurrentEnergy() + value >= characterEnergy) {
            fatigue = 0
        } else {
            fatigue -= value
        }
    }

    fun getCurrentEnergy(): Int {
        if (energy - fatigue <= 0) return 0
        return energy - fatigue
    }

    fun getCurrentLife(): Int {
        if (life - damages <= 0) return 0
        return life - damages
    }

    fun addDamages(value: Int) {
        damages += value
    }

    fun addFatigue(value: Int) {
        fatigue += value
    }

    override fun equals(other: Any?): Boolean {

        return Equatable.getProps<Vitality>(this, other)


    }
}