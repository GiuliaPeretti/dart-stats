package com.example.dartsstats

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.dartsstats.ui.theme.Theme
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun VictoryScreen(
    onAction: (DartsOnAction) -> Unit,
    viewModel: DartsViewModel,
    navController: NavHostController

){
    val state by viewModel.state.collectAsState()
    Column (

    modifier = Modifier
            .fillMaxSize()
            .background(Theme().background)
            .verticalScroll(rememberScrollState())
        .padding(bottom = 100.dp, top = 50.dp)

        , Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            val col1: Color
            val col2: Color
            val name: String
            if (state.game.winner == 1) {
                col1 =  Color(0xFFAB0012)
                col2 = Color(0xFF56010A)
                name = state.game.name1
            }else{
                col1 =  Color(0xFF007E00)
                col2 = Color(0xFF003F00)
                name = state.game.name2
            }
                val gradientColors = listOf(col1, col2)
                Text(
                    text = name,
                    fontSize = 70.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        brush = Brush.linearGradient(
                            colors = gradientColors
                        )
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "won",
                    fontSize = 70.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        brush = Brush.linearGradient(
                            colors = gradientColors
                        )
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }

            ClosureStats(state)
            AverageTab(state)

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally)
            ){
                Button(
                    onClick = {
                        onAction(DartsOnAction.Clear)
                        navController.navigate("home")
                    },
                    colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Theme().onBackground,
                            disabledContainerColor = Color.White,
                            disabledContentColor = Color.Black,
                    ),
                    modifier = Modifier
                        .padding(start = 100.dp, end = 100.dp)
                        .fillMaxWidth()
                ){
                    Text(
                        text = "New game",
                        fontSize = 25.sp
                    )
                }
            }



    }
}