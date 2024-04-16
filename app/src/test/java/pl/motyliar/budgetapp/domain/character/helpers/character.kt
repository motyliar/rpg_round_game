package pl.motyliar.budgetapp.domain.character.helpers

import pl.motyliar.budgetapp.domain.character.Character
import pl.motyliar.budgetapp.domain.character.subclass.ArmorSet
import pl.motyliar.budgetapp.domain.character.subclass.CharacterType
import pl.motyliar.budgetapp.domain.character.subclass.Sword
import pl.motyliar.budgetapp.domain.character.subclass.Vitality
import pl.motyliar.budgetapp.domain.character.subclass.Weapon
import pl.motyliar.budgetapp.domain.character.subclass.armors.LeatherJacket

class WarriorTest(
    override var name: String = "Bogdan",
    override val type: CharacterType = CharacterType.Warrior,
    override val weapon: Weapon = Sword(),
    override val vitality: Vitality = Vitality(
        energy = 20,
        strength = 10,
        intelligence = 10,
        life = 50,
        magic = 10,
        dexterity = 10
    ),
    override val armorSet: ArmorSet = ArmorSet(chest = LeatherJacket())


) : Character(
    name = name,
    type = type, weapon = weapon, vitality = vitality, armorSet = armorSet

) {



}