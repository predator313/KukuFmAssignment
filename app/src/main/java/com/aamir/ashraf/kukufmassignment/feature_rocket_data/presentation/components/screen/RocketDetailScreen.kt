package com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components.screen

import android.util.Log
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.mapper.toRocketDetailModel
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.RocketViewModel
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components.RocketDetail
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components.RocketList
import com.aamir.ashraf.kukufmassignment.utils.Resource

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
fun RocketDetailScreen(
    flightNumber: Int,

    onNavigate: () -> Unit
) {
    val rocketViewModel: RocketViewModel = hiltViewModel()

    // Fetch the rocket details when the screen is composed
    LaunchedEffect(flightNumber) {
        rocketViewModel.getRockDetailByFlightNumber(flightNumber)
    }
    val getRocketDetailState by rocketViewModel.getRocketDetailStateByFn.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Live From Detail Screen $flightNumber")

        when (getRocketDetailState) {
            is Resource.Loading -> {
                Text(text = "Loading...")
            }
            is Resource.Success -> {
                val rocketDetail = (getRocketDetailState as Resource.Success).data
                rocketDetail?.let {
                    RocketDetail(it.toRocketDetailModel())
                }
            }
            is Resource.Error -> {
                val errorMessage = (getRocketDetailState as Resource.Error).message
                Text(text = "Error: $errorMessage")
            }
        }
    }


}
 







