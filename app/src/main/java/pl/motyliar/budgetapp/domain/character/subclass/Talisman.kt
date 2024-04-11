package pl.motyliar.budgetapp.domain.character.subclass

abstract class Talisman(name: String, type: ItemType, price: Int) : Item(name,price, type) {
}