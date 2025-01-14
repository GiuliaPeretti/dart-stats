package com.example.dartsstats
//
//import android.content.Context
//import androidx.compose.runtime.Composable
//import androidx.compose.animation.core.Spring
//import androidx.compose.animation.core.spring
//import androidx.compose.animation.fadeIn
//import androidx.compose.animation.fadeOut
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//
//@Composable
//fun NavigationController(
//    context: Context,
//    viewModel: DartsViewModel
//) {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "home") {
//        composable(
//            route = "home",
//            enterTransition = { fadeIn(animationSpec = spring(stiffness = Spring.StiffnessHigh)) },
//            exitTransition = { fadeOut(animationSpec = spring(stiffness = Spring.StiffnessHigh)) }
//        ) { Stats(navController = navController) }
//    }
//}
