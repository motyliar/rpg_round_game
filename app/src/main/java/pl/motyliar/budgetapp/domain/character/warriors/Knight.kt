package pl.motyliar.budgetapp.domain.character.warriors

import pl.motyliar.budgetapp.domain.character.subclass.ArmorSet
import pl.motyliar.budgetapp.domain.character.subclass.Vitality
import pl.motyliar.budgetapp.domain.character.subclass.Weapon
import pl.motyliar.budgetapp.domain.character.subclass.potion.PotionBelt

open class Knight(name: String, armorSet: ArmorSet, weapon: Weapon) : Warriors(
    name = name,
    armorSet = armorSet,
    vitality = Vitality(31, 15, 50, 1, 30, 50),
    potionBelt = PotionBelt.SmallPotionBelt(),
    weapon = weapon
) {
}