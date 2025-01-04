package com.example.dartsstats

import androidx.compose.foundation.layout.R


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dartsstats.ui.theme.Theme


@Preview
@Composable
fun NavigationBar(
){
    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(70.dp)
                .background(color = Theme().primary),
            verticalAlignment = Alignment.Bottom
        ) {

            Button(
                onClick = { /*navController.navigate("home")*/ },
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Theme().primary)
            ) {
                Text(
                    text = "+",
                    fontSize = 50.sp,
                    color = Theme().onPrimary


                )
            }
            Button(
                onClick = { /*navController.navigate("home")*/ },
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Theme().primary)
            ) {
                Text(
                    text = "+",
                    fontSize = 50.sp,
                    color = Theme().onPrimary

                )
            }
            Button(
                onClick = { /*navController.navigate("home")*/ },
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Theme().primary)
            ) {
               // Image(painter = painterResource(id = R.drawable.stats), contentDescription = null)
                Text(
                    text = "+",
                    fontSize = 50.sp,
                    color = Theme().onPrimary


                )
            }

        }
    }
}