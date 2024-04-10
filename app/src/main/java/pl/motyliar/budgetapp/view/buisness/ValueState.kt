package pl.motyliar.budgetapp.view.buisness

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class ValueState(private val state: SavedStateHandle) : ViewModel() {

    val myNewValue = state.getStateFlow("name", "Wacek")

    fun changeName() {
        state["name"] = "Robert"
    }


}