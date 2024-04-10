package pl.motyliar.budgetapp.view.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pl.motyliar.budgetapp.view.buisness.ValueState
import pl.motyliar.budgetapp.viewmodels.HomeViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomButton(modifier: Modifier) {
    val viewModel = viewModel<HomeViewModel>()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Button(

            onClick = { viewModel.changeContent(surname = "Kapitan") },
        ) {
            Text(text = "Change my value")

        }
        Button(

            onClick = { viewModel.addValue(20) },
        ) {
            Text(text = "Change my value")

        }


}}