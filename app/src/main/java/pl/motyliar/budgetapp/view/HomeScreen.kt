package pl.motyliar.budgetapp.view


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import pl.motyliar.budgetapp.R
import pl.motyliar.budgetapp.ui.theme.*
import pl.motyliar.budgetapp.viewmodels.HomeViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle
import pl.motyliar.budgetapp.view.buisness.ValueState
import pl.motyliar.budgetapp.view.components.CustomButton
import java.time.temporal.TemporalAmount.*


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val viewModel = viewModel<HomeViewModel>()
    val content = viewModel.content.collectAsState()
    val amount = viewModel.amount.collectAsState()
    val newContent = viewModel<ValueState>()
    val name = newContent.myNewValue.collectAsState()
    var textController by remember {
        mutableStateOf("Type here...")
    }





    Surface(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (nameRow, list, card, topBar, field) = createRefs()
            Image(

                painter = painterResource(id = R.drawable.top),
                contentDescription = "App Bar top",
                modifier = Modifier.fillMaxSize(),

                alignment = Alignment.TopCenter
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 16.dp, end = 16.dp)
                    .constrainAs(nameRow) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                horizontalArrangement = Arrangement.SpaceBetween

            )

            {

                Column() {
                    Text(text = content.value.surname, fontSize = 16.sp, color = Color.White)
                    Text(
                        text = content.value.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.search_24),
                    contentDescription = null
                )

            }
            CardItem(modifier = Modifier.constrainAs(card) {
                top.linkTo(nameRow.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }, amount = amount.value.toString())
            TransactionList(modifier = Modifier.constrainAs(list) {
                top.linkTo(card.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)


            })
            CustomButton(modifier = Modifier.constrainAs(topBar) {
                top.linkTo(list.bottom)
                start.linkTo((parent.start))
                end.linkTo(parent.end)
            })
            BasicTextField2(
                textStyle = TextStyle(color = Color.Black),
                modifier = Modifier.constrainAs(field) {
                    top.linkTo(topBar.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                value = textController,
                onValueChange = { viewModel.changeContent(name = it) },
                lineLimits = TextFieldLineLimits.SingleLine
            )
        }
    }
}

@Composable
fun CardItem(modifier: Modifier, amount: String) {
    Column(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(200.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Zink)

            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Text(
                    text = "Total balance",
                    modifier = Modifier.padding(top = 20.dp),
                    color = Color.White
                )

                Text(text = "PLN $amount", color = Color.White, fontSize = 20.sp)
            }
            Image(painter = painterResource(id = R.drawable.dots_24), contentDescription = null)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            CardRowItem(
                title = "Income",
                amount = "3000",
                image = painterResource(id = R.drawable.income)
            )
            CardRowItem(
                title = "Expenses",
                amount = "250",
                image = painterResource(id = R.drawable.expenses)
            )


        }


    }
}

@Composable
fun CardRowItem(title: String, amount: String, image: Painter) {
    Column() {
        Row() {
            Image(painter = image, contentDescription = null)
            Text(
                text = title,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 5.dp),
                color = Color.White
            )
        }
        Text(text = "PLN $amount", fontSize = 20.sp, color = Color.White)

    }
}

@Composable
fun TransactionList(modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Recent transaction", fontSize = 20.sp)
            Text(text = "See all", fontSize = 16.sp)
        }

    }
}

