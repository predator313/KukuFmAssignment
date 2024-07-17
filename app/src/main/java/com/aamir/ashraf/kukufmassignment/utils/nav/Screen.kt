package com.aamir.ashraf.kukufmassignment.utils.nav

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object RocketDetailsScreen : Screen("rocket_details_screen/{rocketId}") {
        fun createRoute(rocketId: Long) = "rocket_details_screen/$rocketId"
    }
}
