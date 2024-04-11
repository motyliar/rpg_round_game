package pl.motyliar.budgetapp.domain.character.subclass

import pl.motyliar.budgetapp.domain.character.subclass.armors.*

class ArmorSet(
    val gloves: Gloves? = null,
    val pants: Pants? = null,
    val chest: Chest? = null,
    val head: Head? = null,
    val boots: Boots? = null,
    val shield: Shield? = null
) {
    fun copyWith(
        gloves: Gloves? = this.gloves,
        pants: Pants? = this.pants,
        chest: Chest? = this.chest,
        head: Head? = this.head,
        boots: Boots? = this.boots,
        shield: Shield? = this.shield
    ): ArmorSet {
        return ArmorSet(gloves, pants, chest, head, boots, shield)
    }

    fun getTotalDefence(): Int {
        return _getTotalDefence()
    }

    private fun _getTotalDefence(): Int {
        return (gloves?.getTotalDefence() ?: 0) +
                (pants?.getTotalDefence() ?: 0) +
                (chest?.getTotalDefence() ?: 0) +
                (head?.getTotalDefence() ?: 0) +
                (boots?.getTotalDefence() ?: 0) +
                (shield?.getTotalDefence() ?: 0)

    }

    override fun toString(): String {
        return "ArmorSet(gloves: $gloves, pants: $pants, chest: $chest, head: $head, boots: $boots, shield: $shield)"
    }

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(other !is ArmorSet) return false

        if(gloves != other.gloves) return false
        if(pants != other.pants) return false
        if(chest != other.chest) return false
        if(head != other.head) return false
        if(boots != other.boots) return false
        if(shield != other.shield) return false

        return true
    }

    override fun hashCode(): Int {
        var result = gloves.hashCode()
        result = 31 * result + pants.hashCode()
        result = 31 * result + chest.hashCode()
        result = 31 * result + head.hashCode()
        result = 31 * result + boots.hashCode()
        result = 31 * result + shield.hashCode()
                return result
    }




}