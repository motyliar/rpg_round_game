package pl.motyliar.budgetapp.domain.character.warriors

import pl.motyliar.budgetapp.domain.character.subclass.ArmorSet
import pl.motyliar.budgetapp.domain.character.subclass.Vitality
import pl.motyliar.budgetapp.domain.character.subclass.Weapon
import pl.motyliar.budgetapp.domain.character.subclass.potion.PotionBelt

class Wizard(name: String, armorSet: ArmorSet, weapon: Weapon) : Warriors(
    name = name,
    armorSet = armorSet,
    vitality = Vitality(15, 35, 50, 30, 30, 35),
    potionBelt = PotionBelt.SmallPotionBelt(),
    weapon = weapon
) {
}