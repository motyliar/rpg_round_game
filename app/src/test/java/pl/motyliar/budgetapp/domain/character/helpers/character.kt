package pl.motyliar.budgetapp.domain.character.helpers

import pl.motyliar.budgetapp.domain.character.Character
import pl.motyliar.budgetapp.domain.character.subclass.ArmorSet
import pl.motyliar.budgetapp.domain.character.subclass.CharacterType
import pl.motyliar.budgetapp.domain.character.subclass.Sword
import pl.motyliar.budgetapp.domain.character.subclass.Vitality
import pl.motyliar.budgetapp.domain.character.subclass.Weapon
import pl.motyliar.budgetapp.domain.character.subclass.armors.LeatherBoots
import pl.motyliar.budgetapp.domain.character.subclass.armors.LeatherJacket
import pl.motyliar.budgetapp.domain.character.warriors.Knight

object KnightTest : Knight("Knight", ArmorSet(boots = LeatherBoots()), Sword())