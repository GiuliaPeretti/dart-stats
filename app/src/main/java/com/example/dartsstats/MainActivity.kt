package com.example.dartsstats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        val navController =     rememberNavController()
        val viewModel = DartsViewModel()

        NavHost(navController = navController, startDestination = "home") {
            composable(
                route="first",
                enterTransition = { fadeIn(animationSpec = spring(stiffness = Spring.StiffnessHigh)) },
            ) {
                StatsScreen(
                    onAction = viewModel::onAction,
                    viewModel = viewModel,
                    navController = navController
                )
            }
            composable(
                route="home",
                enterTransition = { fadeIn(animationSpec = spring(stiffness = Spring.StiffnessHigh)) },
            ) {
                Home(
                    onAction = viewModel::onAction,
                    navController = navController)
            }

            composable(
                route="victory",
                enterTransition = { fadeIn(animationSpec = spring(stiffness = Spring.StiffnessHigh)) },
            ) {
                VictoryScreen(viewModel = viewModel,
                    onAction = viewModel::onAction,
                    navController = navController)
            }


        }

    }



}



