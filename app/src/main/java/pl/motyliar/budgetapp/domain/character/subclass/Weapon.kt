package pl.motyliar.budgetapp.domain.character.subclass


abstract class Weapon(
    val power: Int,
    val resillence: Int,
    name: String,
    price: Int,
    type: ItemType
) :
    Item(name, price, type) {

}