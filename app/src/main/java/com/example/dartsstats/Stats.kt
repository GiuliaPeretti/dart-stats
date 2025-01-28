package com.example.dartsstats

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dartsstats.ui.theme.Theme


//TODO: puntino per chi lancia per primo
//TODO: Barra chi sta lanciando



@Composable
fun StatsScreen(
        onAction: (DartsOnAction) -> Unit,
    viewModel: DartsViewModel,
    navController: NavHostController
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color =Theme().background)
            .padding(bottom = 100.dp, top = 50.dp)

        //.background(color = Color.White)
    ) {

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
        Box(
            modifier = Modifier
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(15.dp))


        ) {
            Box(
                modifier = Modifier
                    .background(Theme().onTertiary)


            ) {
                Inputs(state, onAction, navController)
            }
        }

        ScoreTab(state)
        AverageTab(state)

        ClosureStats(state)



    }
    //NavigationBar()
}

@Composable
fun Inputs(state: DartsState, onAction: (DartsOnAction) -> Unit, navController: NavHostController){
    Column(modifier=Modifier
        .fillMaxWidth()
        //.padding(2.dp)
        .clip(shape = RoundedCornerShape(15.dp))
        .background(color = Theme().tertiary)
        //.border(2.dp, color = Theme().onTertiary, shape = RoundedCornerShape(15.dp))

    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(height = 70.dp)
            .padding(top = 10.dp)
            //.border(width = 1.dp, color = Theme().onBackground)
            //.background(color = Theme().onBackground)
        ){
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight()
                    .padding(start = 15.dp, end = 15.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .gradient(1)
                    //.border(width = 1.dp, color = Theme().onBackground)

                ,Arrangement.Center
            ) {
                Text(
                    text = state.game.name1,
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .fillMaxHeight()
//                    //.border(width = 1.dp, color = Theme().onBackground)
//                    //.background(color = Color.Black),
//                , Arrangement.Center
//            ) {
//                Text(
//                    text = "",
//                    fontSize = 30.sp,
//                    modifier = Modifier
//                        .align(Alignment.CenterHorizontally)
//                )
//            }
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight()
                    .padding(start = 15.dp, end = 15.dp)

                    .clip(shape = RoundedCornerShape(15.dp))
                    .gradient(2)
                    //.border(width = 1.dp, color = Theme().onBackground)
                , Arrangement.Center
            ) {
                Text(
                    text = state.game.name2,
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }

        }



        InputBox(onAction, state, navController)


//        val n by remember { mutableStateOf("") }
//
//        for(i in 1..3){
//            Row(modifier = Modifier,
//                Arrangement.Center
//
//            ) {
//
//
//                Row(
//                    modifier = Modifier
//                        .weight(2f)
//                        .align(Alignment.CenterVertically),
//                    Arrangement.Center
//                ) {
//                    NumericInputField(
//                        value = n,true
//                        onValueChange = { newInput -> n = newInput }
//
//                    )
//                }
//
//                Row(
//                    modifier = Modifier
//                        .weight(1f)
//                        .align(Alignment.CenterVertically),
//                    Arrangement.Center
//                ) {
//                    Text(text = i.toString(), fontSize = 30.sp)
//                }
//
//
//                Row(modifier = Modifier
//                    .weight(2f)) {
//                NumericInputField(
//                    value = n,
//                    onValueChange = { newInput -> n = newInput }
//
//                )
//            }
//
//            }
//        }
//
//
//        Row(modifier = Modifier
//            .fillMaxWidth()
//            .height(height = 50.dp)
//            //.border(width = 1.dp, color = Theme().onBackground)
//            .background(color = Theme().tertiary)
//        ){
//            Column(
//                modifier = Modifier
//                    .weight(2f)
//                    .fillMaxHeight()
//                    //.border(width = 1.dp, color = Theme().onBackground)
//                    .background(color = Theme().tertiary),
//                Arrangement.Center
//            ) {
//                Button(
//                    onClick = {onAction(DartsOnAction.UpdateScore(mutableListOf("","",""), true))},
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .fillMaxHeight()
//                        .padding(5.dp)
//                ) {
//                    Text(text = "Go")
//                }
//            }
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .fillMaxHeight()
//                    //.border(width = 1.dp, color = Theme().onBackground)
//                    .background(color = Theme().tertiary),
//                Arrangement.Center
//            ) {
//
//            }
//            Column(
//                modifier = Modifier
//                    .weight(2f)
//                    .fillMaxHeight()
//                    //.border(width = 1.dp, color = Theme().onBackground)
//                    .background(color = Theme().tertiary),
//                Arrangement.Center
//            ) {
//                Button(
//                    onClick = {},
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .fillMaxHeight()
//                        .padding(5.dp)
//                ) {
//                    Text(text = "bo")
//                }
//            }
//
//        }


    }
}

@Composable
fun RowScore(name: String, scores: MutableList<Int>,lineWidth: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 100.dp)
            //.border(width = 1.dp, color = Theme().onBackground)
            .background(color = Theme().tertiary)
            .bottomBorder(lineWidth.dp, Color.Black)

    ) {


        Column(modifier = Modifier
            .weight(3f)
            .fillMaxHeight()
            //.border(width = 1.dp, color = Theme().onBackground),
            ,Arrangement.Center

        ) {
            Text(
                text = name,
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.Start)

            )
        }

        Column(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            //.border(width = 1.dp, color = Theme().onBackground),
            ,Arrangement.Center

        ) {
            Text(
                text = scores[0].toString(),
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),

                )
        }


        Column(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            //.border(width = 1.dp, color = Theme().onBackground),
            ,Arrangement.Center

        ) {
            Text(
                text = scores[1].toString(),
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),

                )
        }
        Column(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            //.border(width = 1.dp, color = Theme().onBackground),
            ,Arrangement.Center

        ) {
            Text(
                text = scores[2].toString(),
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),

                )
        }

    }
}

fun Modifier.bottomBorder(strokeWidth: Dp, color: Color) = composed {
    val density = LocalDensity.current
    val strokeWidthPx = with(density) { strokeWidth.toPx() }

    if (strokeWidthPx > 0) {
        Modifier.drawBehind {
            val width = size.width
            val height = size.height - strokeWidthPx

            drawLine(
                color = color,
                start = Offset(x = 0f, y = height),
                end = Offset(x = width, y = height),
                strokeWidth = strokeWidthPx
            )
        }
    } else {
        this // Return the unchanged Modifier when strokeWidth is 0
    }
}

fun Modifier.leftBorder(strokeWidth: Dp, color: Color) = composed {
    val density = LocalDensity.current
    val strokeWidthPx = with(density) { strokeWidth.toPx() }

    if (strokeWidthPx > 0) {
        Modifier.drawBehind {
            val height = size.height
            val startX = strokeWidthPx / 2f // Center the stroke width along the x-axis

            drawLine(
                color = color,
                start = Offset(x = startX, y = 0f),
                end = Offset(x = startX, y = height),
                strokeWidth = strokeWidthPx
            )
        }
    } else {
        this // Return the unchanged Modifier when strokeWidth is 0
    }
}

fun Modifier.rightBorder(strokeWidth: Dp, color: Color) = composed {
    val density = LocalDensity.current
    val strokeWidthPx = with(density) { strokeWidth.toPx() }

    if (strokeWidthPx > 0) {
        Modifier.drawBehind {
            val height = size.height
            val width = size.width

            drawLine(
                color = color,
                start = Offset(x = width, y = 0f), // Top-right corner
                end = Offset(x = width, y = height), // Bottom-right corner
                strokeWidth = strokeWidthPx
            )
        }
    } else {
        this // Return the unchanged Modifier when strokeWidth is 0
    }
}




fun Modifier.gradient(color: Int) = composed(
    factory = {
        var color1 = Color(0xFFFFB2B9)
        var color2 = Color(0xFFEF84AF)
        if (color == 1){
            color1 =  Color(0xFFAB0012)
            color2 = Color(0xFF56010A)

        }else if(color == 2){
            color1 = Color(0xFF007E00)
            color2 = Color(0xFF003F00)
        }

        Modifier.drawBehind {
            val brush = Brush.linearGradient(
                listOf(
                   color1,
                    color2
                )
            )
            drawRect(
                brush = brush,
                size = size, // Confine the gradient to the size of the column
            )
        }
    }
)




@Composable
fun ScoreTab(state: DartsState) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .height(height = 260.dp)
        .clip(RoundedCornerShape(15.dp))
        .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 0.dp)
        //.border(2.dp, color = Theme().onTertiary, shape = RoundedCornerShape(15.dp))

        //.background(color = Color.Magenta)

    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 100.dp)
                    //.border(width = 1.dp, color = Theme().onBackground)
                    .weight(1f)
                    .background(color = Theme().onBackground)

            ) {

                Column(modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight()
                    .background(Color.Black)
                    .border(width = 1.dp, color = Color.Transparent),
                    Arrangement.Center

                ) {
                    Text(
                        text = "First to " + state.game.maxSet +" sets",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .align(Alignment.Start)

                    )
                }

                Column(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .gradient(2)
                    .border(width = 1.dp, color = Color.Transparent),
                    Arrangement.Center

                ) {
                    Text(
                        text = "Set",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        )
                }


                Column(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .gradient(1)
                    .border(width = 1.dp, color = Color.Transparent),
                    Arrangement.Center

                ) {
                    Text(
                        text = "Leg",
                        fontSize = 20.sp,
                        color = Color.White,
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

            RowScore(state.game.name1, state.game.Scores[0], 1)
            RowScore(state.game.name2, state.game.Scores[1], 0)


        }

    }
}

@Composable
fun AverageTab(state: DartsState){
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(start = 10.dp, end = 10.dp, top = 10.dp)


    ){
        Row(modifier = Modifier
            .height(height = 50.dp)
            .fillMaxWidth()
            .background(color = Theme().tertiary)

        ) {

            Column(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .border(width = 1.dp, color = Color.White)
                .background(color = Color.White),
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
                .clip(RoundedCornerShape(topStart = 15.dp))
                .gradient(1)
                .align(Alignment.CenterVertically)
                .fillMaxHeight()
                //.border(width = 1.dp, color = Theme().onBackground),
                ,    verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = state.game.name1,
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(Alignment.CenterHorizontally)

                )
            }

            Column(modifier = Modifier
                .weight(3f)
                //.gradient(10.dp, 1)()
                .clip(RoundedCornerShape(topEnd = 15.dp))
                .gradient( 2)
                .align(Alignment.CenterVertically)
                .fillMaxHeight()
                //.border(width = 1.dp, color = Theme().onBackground),
                ,    verticalArrangement = Arrangement.Center

            ) {
                Text(
                    text = state.game.name2,
                    fontSize = 30.sp,
                    color = Color.White,
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
                .bottomBorder(1.dp, Color.Black)
                .background(color = Theme().tertiary)

        ){
            Column(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .clip(RoundedCornerShape(topStart = 15.dp))
                //.border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().onBackground),
                Arrangement.Center
            ){
                Text(
                    text = "All",
                    fontSize = 30.sp,
                    color = Theme().tertiary,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)


                )
            }

            Column(modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
                //.border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().tertiary)
                .rightBorder(2.dp, Color.Black)
                .bottomBorder(1.dp, Color.Black)

                ,
                Arrangement.Center
            ){
                Text(
                    text = state.game.avgs[0][0].toString(),
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
            Column(modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
                //.border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().tertiary)
                .bottomBorder(1.dp, Color.Black)

                ,
                Arrangement.Center
            ){
                Text(
                    text = state.game.avgs[0][1].toString(),
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }

        }
            for (i in 0..<state.game.sets.size) {
                val avg1 = state.game.avgs[i+1][0]
                val avg2 = state.game.avgs[i+1][1]
                val c = if(i == state.game.sets.size-1){
                    15
                }else{
                    0
                }
                val b = if(i == state.game.sets.size-1){
                    0
                }else{
                    1
                }
                AverageRow(i, avg1, avg2, c, b)
            }

    }

}

@Composable
fun AverageRow(n: Int, avg1: Double, avg2: Double, c:Int, b: Int){
    Row(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth()
            //.bottomBorder(1.dp, Color.Black)
            .clip(RoundedCornerShape(bottomEnd = c.dp))
            .background(color = Theme().tertiary)

    ) {
        val color: Int = if (n%2==0){
            2

        }else{
            1
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()

            //.border(width = 1.dp, color = Theme().onBackground)
                //.background(color = color)
                .clip(RoundedCornerShape(bottomStart = c.dp))
                .gradient(color)
            ,Arrangement.Center
        ) {
            Text(
                text = n.toString(),
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }

        Column(
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
                //.border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().tertiary)
                .rightBorder(2.dp, Color.Black)
                .bottomBorder(b.dp, Color.Black)

            ,Arrangement.Center
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
                .clip(RoundedCornerShape(bottomEnd = c.dp))

                //.border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().tertiary)
                .clip(RoundedCornerShape(bottomEnd = c.dp))
                .bottomBorder(b.dp, Color.Black)

            ,
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
fun ClosureStats(state: DartsState){
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp, start = 10.dp, end = 10.dp)
        .clip(RoundedCornerShape(15.dp))

    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(height = 70.dp)
            //.border(width = 1.dp, color = Theme().onBackground)
            //.background(color = Theme().tertiary)
        ){
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    //.border(width = 1.dp, color = Theme().onBackground)
                    .gradient( 1)
                , Arrangement.Center
            ) {
                Text(
                    text = state.game.name1,
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .border(width = 1.dp, color = Theme().onBackground)
                    .background(color = Theme().onBackground),
                Arrangement.Center
            ) {
                Text(
                    text = state.game.Scores[0][0].toString()+"-"+state.game.Scores[1][0].toString(),
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
            Column(
                modifier = Modifier
                    .weight(2f)
                     .fillMaxHeight()
                    //.border(width = 1.dp, color = Theme().onBackground)
                    .gradient(2)
                , Arrangement.Center
            ) {
                Text(
                    text = state.game.name2,
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }

        }
        Row(modifier = Modifier
            .height(height = 40.dp)
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .background(Theme().tertiary)
            .bottomBorder( 1.dp, color = Theme().onBackground)
            ,Arrangement.Center
        ){

            val setResult = state.game.setsRecords
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
        val categorys: Array<String> = arrayOf("100+","140+", "180", "Highest checkout", "100+ checkout","Nine Darts")
        for (i in categorys.indices){
            val c1 = state.game.closureStats[categorys[i]]?.get(0)
            val c2 = state.game.closureStats[categorys[i]]?.get(1)
            val b = if(i==categorys.indices.last()){
                0
            }else{
                1
            }

            if (c1 != null && c2 != null) {
                ClosureBar(categorys[i],c1,c2,b )
            }
        }
    }

}

@Composable
fun ClosureBar(category: String, stat1: Int, stat2: Int, b:Int) {
    Row {
        Column(
            modifier = Modifier
                .weight(1f)
                .height(40.dp)
                //.border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().tertiary)
                .bottomBorder(b.dp, Color.Black)
                .rightBorder(1.dp, Color.Black)

            ,
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
                .height(40.dp)
                .background(color = Theme().tertiary)
                .leftBorder(1.dp ,Color.Black)
                //.rightBorder(1.dp, Color.Black)
                .bottomBorder(b.dp, Color.Black)

            ,
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
                .height(40.dp)
                //.border(width = 1.dp, color = Theme().onBackground)
                .background(color = Theme().tertiary)
                .bottomBorder(b.dp, Color.Black)
                .leftBorder(1.dp, Color.Black)
                ,
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
        modifier = Modifier
            //.border(1.dp, color = Color.Gray)
            .padding(5.dp)
            .clip(RoundedCornerShape(15.dp))
,
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
        ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Theme().tertiary, // Background color when focused
            unfocusedContainerColor = Theme().tertiary, // Background color when unfocused
            disabledContainerColor = Color.Black, // Background color when disabled
            focusedIndicatorColor = Color.Black, // Color of the underline when focused
            unfocusedIndicatorColor = Color.Black, // Color of the underline when unfocused
            focusedLabelColor = Color.Black, // Label color when focused
            unfocusedLabelColor = Color.Black // Label color when unfocused
        ),


    )
}


@Composable
fun InputBox(onAction: (DartsOnAction) -> Unit, state: DartsState, navController: NavHostController){
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Theme().tertiary)
    ){
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(start = 15.dp, end = 15.dp)
        ){
        var n1 by remember { mutableStateOf("") }
        var n2 by remember { mutableStateOf("") }
        var n3 by remember { mutableStateOf("") }

            Row(
                modifier = Modifier
                    //.align(Alignment.CenterVertically),
                , Arrangement.Center
            ) {
                NumericInputField(
                    value = n1,
                    onValueChange = { newInput -> n1 = newInput }

                )
            }

            Row(
                modifier = Modifier,
                //.align(Alignment.CenterVertically),
                Arrangement.Center
            ) {
                NumericInputField(
                    value = n2,
                    onValueChange = { newInput -> n2 = newInput }

                )
            }

            Row(
                modifier = Modifier,
                //.align(Alignment.CenterVertically),
                Arrangement.Center
            ) {
                NumericInputField(
                    value = n3,
                    onValueChange = { newInput -> n3 = newInput }

                )
            }

            Button(
                colors = ButtonColors(
                    contentColor = Color.White,
                    containerColor = Theme().onBackground,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.Black,
                ),
                    onClick = {
                        if(n1==""){
                            n1="0"
                        }
                        if(n2==""){
                            n2="0"
                        }
                        if(n3==""){
                            n3="0"
                        }
                        onAction(DartsOnAction.UpdateScore(listOf(n1.toInt(),n2.toInt(),n3.toInt()), true))

                        if(state.game.winner==-1){
                            navController.navigate("first")

                        }else {
                            navController.navigate("victory")
                        }
                              },
                    modifier = Modifier
                        .fillMaxWidth()
                        //.fillMaxHeight()
                        .padding(5.dp)
                ) {
                    Text(text = "Go")
                }

        }

//        Column (modifier = Modifier
//            .align(alignment = Alignment.CenterVertically)
//            .fillMaxHeight()
//            .weight(1f),
//            Arrangement.SpaceBetween,
//        ){
//            for(i in 1..3) {
//                Row(
//                    modifier = Modifier
//                        .align(Alignment.CenterHorizontally)
//                        .border(1.dp, Color.Black)
//                ) {
//                    Text(text = i.toString(),
//                        fontSize = 30.sp,
//                        modifier = Modifier
//                            .align(Alignment.CenterVertically)
//                    )
//
//                }
//            }
//
//        }




        Column(
            modifier = Modifier
                .weight(3f)
                .padding(start = 15.dp, end = 15.dp)

        ){
            var n4 by remember { mutableStateOf("") }
            var n5 by remember { mutableStateOf("") }
            var n6 by remember { mutableStateOf("") }

            Row(
                modifier = Modifier,
                //.align(Alignment.CenterVertically),
                Arrangement.Center
            ) {
                NumericInputField(
                    value = n4,
                    onValueChange = { newInput -> n4 = newInput }

                )
            }

            Row(
                modifier = Modifier,
                //.align(Alignment.CenterVertically),
                Arrangement.Center
            ) {
                NumericInputField(
                    value = n5,
                    onValueChange = { newInput -> n5 = newInput }

                )
            }

            Row(
                modifier = Modifier ,
                //.align(Alignment.CenterVertically),
                Arrangement.Center
            ) {
                NumericInputField(
                    value = n6,
                    onValueChange = { newInput -> n6 = newInput }

                )
            }





            Button(
                colors = ButtonColors(
                    contentColor = Color.White,
                    containerColor = Theme().onBackground,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.Black,
                ),
                onClick = {
                            if(n4==""){
                                n4="0"
                            }
                            if(n5==""){
                                n5="0"
                            }
                            if(n6==""){
                                n6="0"
                            }
                            state.game.updateScore(listOf(n4.toInt(),n5.toInt(),n6.toInt()), false)
                            navController.navigate("first")
                            if(state.game.winner==-1){
                                navController.navigate("first")

                            }else {
                                navController.navigate("victory")
                            }
                            },
                modifier = Modifier
                    .fillMaxWidth()
                    //.fillMaxHeight()
                    .padding(5.dp)
            ) {
                Text(text = "Go")
            }

        }

    }
}



