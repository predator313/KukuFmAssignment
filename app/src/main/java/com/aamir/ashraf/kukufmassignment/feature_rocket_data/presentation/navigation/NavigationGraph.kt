package com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.navigation

import android.util.Log
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components.screen.MainScreen
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components.screen.RocketDetailScreen


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MyNavigationHost(

    navController: NavHostController = rememberNavController()
) {
    SharedTransitionLayout {
        NavHost(navController = navController, startDestination = MainScreenNav) {
            composable<MainScreenNav> {
               MainScreen(

               ){
                   navController.navigate(DetailScreenNav(it.flightNumber))
               }
            }
            composable<DetailScreenNav> {
                val detailScreenNav:DetailScreenNav = it.toRoute()
                RocketDetailScreen(
                    flightNumber = detailScreenNav.flightNumber,
                ){
                    navController.navigateUp()
                }
            }


        }

    }
}