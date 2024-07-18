package com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components.screen

import android.util.Log
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.mapper.toRocketDetailModel
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.RocketViewModel
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components.RocketDetail
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Details Of FlightNumber $flightNumber",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))

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
}
