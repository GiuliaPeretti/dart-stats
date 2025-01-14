package com.example.dartsstats

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dartsstats.ui.theme.Theme



//TODO: puntino per chi lancia per primo
//TODO: Barra chi sta lanciando



@Preview
@Composable
fun StatsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Theme().background)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 100.dp, top = 50.dp)

        //.background(color = Color.White)
    ) {

        var numberInput by remember { mutableStateOf("") }

//        NumericInputField(
//            value = numberInput,
//            onValueChange = { newInput -> numberInput = newInput }
//        )
//
//        Row(modifier = Modifier
//            .fillMaxWidth()
//            .height(70.dp)
//            .background(color = Color.Magenta)
//        ){
//
//        }
        Inputs()
        ScoreTab()

        ClosureStats()

        AverageTab()
    }
    //NavigationBar()
}

@Composable
fun Inputs(){
    Column(modifier=Modifier
        .fillMaxWidth()
        .background(color = Theme().background)
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(height = 50.dp)
            .border(width = 1.dp, color = Theme().onBackground)
            .background(color = Theme().background)
        ){
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    .border(width = 1.dp, color = Theme().onBackground)
                    .background(color = Theme().background),
                Arrangement.Center
            ) {
                Text(
                    text = "Nome",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .border(width = 1.dp, color = Theme().onBackground)
                    .background(color = Theme().background),
                Arrangement.Center
            ) {
                Text(
                    text = "3-5",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    .border(width = 1.dp, color = Theme().onBackground)
                    .background(color = Theme().background),
                Arrangement.Center
            ) {
                Text(
                    text = "Nome",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }

        }


        for(i in 1..3){
            Row(modifier = Modifier,
                Arrangement.Center

            ) {
                var numberInput1 by remember { mutableStateOf("") }
                var numberInput2 by remember { mutableStateOf("") }

                Row(
                    modifier = Modifier
                        .weight(2f)
                        .align(Alignment.CenterVertically),
                    Arrangement.Center
                ) {
                    NumericInputField(
                        value = numberInput1,
                        onValueChange = { newInput -> numberInput1 = newInput }
                    )
                }

                Row(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    Arrangement.Center
                ) {
                    Text(text = i.toString(), fontSize = 30.sp)
                }


                Row(modifier = Modifier
                    .weight(2f)) {
                NumericInputField(
                    value = numberInput2,
                    onValueChange = { newInput -> numberInput2 = newInput }
                )
            }

            }
        }


        Row(modifier = Modifier
            .fillMaxWidth()
            .height(height = 50.dp)
            //.border(width = 1.dp, color = Theme().onBackground)
            .background(color = Theme().background)
        ){
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    //.border(width = 1.dp, color = Theme().onBackground)
                    .background(color = Theme().background),
                Arrangement.Center
            ) {
                Button(
                    onClick = {/*TODO*/},
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(5.dp)
                ) {
                    Text(text = "Go")
                }
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    //.border(width = 1.dp, color = Theme().onBackground)
                    .background(color = Theme().background),
                Arrangement.Center
            ) {

            }
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    //.border(width = 1.dp, color = Theme().onBackground)
                    .background(color = Theme().background),
                Arrangement.Center
            ) {
                Button(
                    onClick = {/*TODO*/},
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(5.dp)
                ) {
                    Text(text = "bo")
                }
            }

        }


    }
}

@Composable
fun RowScore() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 100.dp)
            .border(width = 1.dp, color = Theme().onBackground)
            .background(color = Theme().background)

    ) {

        Column(modifier = Modifier
            .weight(3f)
            .fillMaxHeight()
            .border(width = 1.dp, color = Theme().onBackground),
            Arrangement.Center

        ) {
            Text(
                text = "Nome",
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.Start)

            )
        }

        Column(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .border(width = 1.dp, color = Theme().onBackground),
            Arrangement.Center

        ) {
            Text(
                text = "2",
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),

                )
        }


        Column(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .border(width = 1.dp, color = Theme().onBackground),
            Arrangement.Center

        ) {
            Text(
                text = "2",
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),

                )
        }
        Column(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .border(width = 1.dp, color = Theme().onBackground),
            Arrangement.Center

        ) {
            Text(
                text = "501",
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),

                )
        }

    }
}


@Composable
fun ScoreTab(){
    Row (modifier = Modifier
        .fillMaxWidth()
        .height(height = 260.dp)
        .padding(start = 5.dp, end = 5.dp, top = 10.dp, bottom = 0.dp)
        .background(color = Color.Magenta)

    ){
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 100.dp)
                    .border(width = 1.dp, color = Theme().onBackground)
                    .weight(1f)
                    .background(color = Theme().background)

            ) {

                Column(modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight()
                    .border(width = 1.dp, color = Color.Transparent),
                    Arrangement.Center

                ) {
                    Text(
                        text = "First to 6 sets",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .align(Alignment.Start)

                    )
                }

                Column(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .border(width = 1.dp, color = Color.Transparent),
                    Arrangement.Center

                ) {
                    Text(
                        text = "Set",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),

                        )
                }


                Column(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .border(width = 1.dp, color = Color.Transparent),
                    Arrangement.Center

                ) {
                    Text(
                        text = "Leg",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),

                        )
                }
                Column(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .border(width = 1.dp, color = Color.Transparent),
                    Arrangement.Center

                ) {
                    Text(
                        text = "",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),

                        )
                }

            }

            RowScore()
            RowScore()


        }

    }
}

@Composable
fun AverageTab(){
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(start = 5.dp, end = 5.dp, top = 10.dp)


    ){
        Row(modifier = Modifier
            .height(height = 50.dp)
            .fillMaxWidth()
            .background(color = Theme().background)
            .border(width = 1.dp, color = Theme().onBackground)

        ) {

            Column(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().background),
                Arrangement.Center
            ){
                Text(
                    text = "",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)


                )
            }

            Column(modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
                .border(width = 1.dp, color = Theme().onBackground),
                Arrangement.Center

            ) {
                Text(
                    text = "Name",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(Alignment.CenterHorizontally)

                )
            }

            Column(modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
                .border(width = 1.dp, color = Theme().onBackground),
                Arrangement.Center

            ) {
                Text(
                    text = "Name",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(Alignment.CenterHorizontally)

                )
            }
        }

        Row(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
                .border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().background)

        ){
            Column(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().background),
                Arrangement.Center
            ){
                Text(
                    text = "All",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)


                )
            }

            Column(modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
                .border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().background),
                Arrangement.Center
            ){
                Text(
                    text = "98.56",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
            Column(modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
                .border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().background),
                Arrangement.Center
            ){
                Text(
                    text = "102.45",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }

        }

        for (i in 1..6){
            AverageRow(i,20.8,30.3)
        }

    }

}

@Composable
fun AverageRow(n: Int, avg1: Double, avg2: Double){
    Row(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth()
            .border(width = 1.dp, color = Theme().onBackground)
            .background(color = Theme().background)

    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().background),
            Arrangement.Center
        ) {
            Text(
                text = n.toString(),
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)


            )
        }

        Column(
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
                .border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().background),
            Arrangement.Center
        ) {
            Text(
                text = avg1.toString(),
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
        Column(
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
                .border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().background),
            Arrangement.Center
        ) {
            Text(
                text = avg2.toString(),
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }

}


@Composable
fun ClosureStats(){
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp, start = 5.dp, end = 5.dp)
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(height = 70.dp)
            .border(width = 1.dp, color = Theme().onBackground)
            .background(color = Theme().background)
        ){
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    .border(width = 1.dp, color = Theme().onBackground)
                    .background(color = Theme().background),
                Arrangement.Center
            ) {
                Text(
                    text = "Nome",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .border(width = 1.dp, color = Theme().onBackground)
                    .background(color = Theme().background),
                Arrangement.Center
            ) {
                Text(
                    text = "3-5",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    .border(width = 1.dp, color = Theme().onBackground)
                    .background(color = Theme().background),
                Arrangement.Center
            ) {
                Text(
                    text = "Nome",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }

        }
        Row(modifier = Modifier
            .height(height = 40.dp)
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .border(width = 1.dp, color = Theme().onBackground),
            Arrangement.Center
        ){
            val setResult: Array<String> = arrayOf("4-1","2-3","3-0","3-1","2-3","3-0","3-1","2-3","3-0")
            for(i in setResult){
                Text(text = i,
                    color = Theme().onBackground,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(start = 5.dp, end = 5.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
        val categorys: Array<String> = arrayOf("100+ scores","140+ scores", "180 scores", "Highest checkout", "100+ checkout", "Checkout summary")
        for (i in categorys){
            ClosureBar(i, 23,38)
        }
    }

}

@Composable
fun ClosureBar(category: String, stat1: Int, stat2: Int) {
    Row() {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .height(40.dp)
                .border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().background),
            Arrangement.Center
        ) {
            Text(
                text = stat1.toString(),
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
        Column(
            modifier = Modifier
                .weight(2f)
                .fillMaxHeight()
                .height(40.dp)
                .border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().background),
            Arrangement.Center
        ) {
            Text(
                text = category,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .height(40.dp)
                .border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().background),
            Arrangement.Center
        ) {
            Text(
                text = stat2.toString(),
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }



}



@Composable
fun NumericInputField(
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = { input ->
            // Allow only digits
            if (input.all { it.isDigit() }) {
                onValueChange(input)
            }
        },
        label = { Text("Enter a number") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number // Numeric keyboard
        )
    )
}


