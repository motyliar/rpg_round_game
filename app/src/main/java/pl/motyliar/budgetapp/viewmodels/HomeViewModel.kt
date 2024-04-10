package pl.motyliar.budgetapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


data class Person(val name: String, val surname: String) {
    fun copyWith(name: String? = this.name, surname: String? = this.surname): Person {
        return Person(name = name ?: this.name, surname = surname ?: this.surname)
    }
}

class HomeViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {

     private val _content = MutableStateFlow<Person>(Person("Wojtek", "Bartoszew"))
        var content = _content.asStateFlow()
    var textValue by  mutableStateOf("Initial")
    private val _amount = MutableStateFlow<Int>(2000)
    val amount = _amount.asStateFlow()


    fun setNewValue(newValue: String) {

        textValue = newValue
    }
    fun addValue(value: Int) {
        _amount.value += value
    }

    fun changeContent(name: String? = null, surname: String? = null) {
        val person = _content.value
        _content.value = person.copyWith(name, surname)


    }



}