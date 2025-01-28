package com.example.dartsstats

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dartsstats.ui.theme.Theme



@Composable
fun Home(
    onAction: (DartsOnAction) -> Unit,
    navController: NavHostController
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Theme().tertiary)
            , Arrangement.Center
    )
    {
        Column(
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp)

        ) {
            var name1 by remember { mutableStateOf("Player1") }
            var name2 by remember { mutableStateOf("Player2") }

            Column(
                modifier = Modifier
                    .background(Theme().tertiary)
                    .fillMaxWidth()


            ) {
//            Text(
//                text = "Name: ",
//                fontSize = 20.sp,
//                modifier = Modifier
//                    .align(Alignment.Start)
//                //.fillMaxHeight()
//            )
                TextField(
                    value = name1,
                    onValueChange = { name1 = it },
                    label = { Text("Name") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, end = 5.dp, bottom = 4.dp)
                        .clip(RoundedCornerShape(30.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFD9D4C8),
                        unfocusedContainerColor = Color(0xFFD9D4C8),
                        focusedIndicatorColor = Color.Transparent, // Remove underline when focused
                        unfocusedIndicatorColor = Color.Transparent, // Remove underline when unfocused
                        disabledIndicatorColor = Color.Transparent // Remove underline when disabled

                    ),
                )
            }

            Column(
                modifier = Modifier
                    .background(Theme().tertiary)
                    .fillMaxWidth()

            ) {
//            Text(
//                text = "Player2: ",
//                fontSize = 20.sp,
//                modifier = Modifier
//                    .align(Alignment.Start)
//                //.fillMaxHeight()
//            )
                TextField(
                    value = name2,
                    onValueChange = { name2 = it },
                    label = { Text("Name") },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFD9D4C8),
                        unfocusedContainerColor = Color(0xFFD9D4C8),
                        focusedIndicatorColor = Color.Transparent, // Remove underline when focused
                        unfocusedIndicatorColor = Color.Transparent, // Remove underline when unfocused
                        disabledIndicatorColor = Color.Transparent // Remove underline when disabled
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, end = 5.dp, bottom = 4.dp)
                        .clip(RoundedCornerShape(30.dp))
                )
            }


            var sets by remember { mutableStateOf("6") }
            Column(
                modifier = Modifier
                    .background(Theme().tertiary)
                    .fillMaxWidth()

            ) {
//            Text(
//                text = "Sets: ",
//                fontSize = 20.sp,
//                modifier = Modifier
//                    .align(Alignment.Start)
//                //.fillMaxHeight()
//            )
                TextField(
                    value = sets,
                    onValueChange = { sets = it },
                    label = { Text("Sets") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFD9D4C8),
                        unfocusedContainerColor = Color(0xFFD9D4C8),
                        focusedIndicatorColor = Color.Transparent, // Remove underline when focused
                        unfocusedIndicatorColor = Color.Transparent, // Remove underline when unfocused
                        disabledIndicatorColor = Color.Transparent // Remove underline when disabled
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, end = 5.dp, bottom = 4.dp)
                        .clip(RoundedCornerShape(30.dp))
                )
            }

            var legs by remember { mutableStateOf("3") }
            Column(
                modifier = Modifier
                    .background(Theme().tertiary)
                    .fillMaxWidth()

            ) {
//            Text(
//                text = "Legs: ",
//                fontSize = 20.sp,
//                modifier = Modifier
//                    .align(Alignment.Start)
//                //.fillMaxHeight()
//            )
                TextField(
                    value = legs,
                    onValueChange = { legs = it },
                    label = { Text("Legs") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFD9D4C8),
                        unfocusedContainerColor = Color(0xFFD9D4C8),
                        focusedIndicatorColor = Color.Transparent, // Remove underline when focused
                        unfocusedIndicatorColor = Color.Transparent, // Remove underline when unfocused
                        disabledIndicatorColor = Color.Transparent // Remove underline when disabled
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, end = 5.dp, bottom = 4.dp)
                        .clip(RoundedCornerShape(30.dp))
                )
            }
            Row {

                Button(
                    colors = ButtonColors(
                        contentColor = Color.White,
                        containerColor = Theme().onBackground,
                        disabledContainerColor = Color.White,
                        disabledContentColor = Color.Black,
                    ),
                    onClick = {
                        onAction(DartsOnAction.StartGame(name1, name2, sets, legs))
                        navController.navigate("first")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        //.fillMaxHeight()
                        .padding(5.dp)
                ) {
                    Text(text = "Start")
                }
            }

        }
    }
}