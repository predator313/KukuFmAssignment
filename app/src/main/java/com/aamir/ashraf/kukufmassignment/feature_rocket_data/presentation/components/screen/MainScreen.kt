package com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.model.RocketMainScreenModel
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.RocketViewModel
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components.RocketList
import com.aamir.ashraf.kukufmassignment.utils.Resource
import com.aamir.ashraf.kukufmassignment.utils.isNetworkAvailable

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
fun MainScreen(
    onItemClick: (RocketMainScreenModel) -> Unit,
) {
    val context =  LocalContext.current

    val rocketViewModel: RocketViewModel = hiltViewModel()
    val getRocketDetailsState by rocketViewModel.getRocketState.collectAsState()
    val rocketMainScreenList by rocketViewModel.rocketMainScreenModelList.collectAsState()

    // Search query implementation
    var searchQuery by remember { mutableStateOf("") }
    val filteredRocketList = rocketMainScreenList.filter {
        it.missionName.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                // Search Bar at the top
                AnimatedVisibility(
                    visible = rocketMainScreenList.isNotEmpty(),
                    modifier = Modifier.align(Alignment.TopCenter)
                ) {
                    Column {
                        TextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text(text = "Search by Mission Name") }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        when (getRocketDetailsState) {
                            is Resource.Loading<*> -> {
                                Text(text = "Loading...")
                            }
                            is Resource.Success<*> -> {
                                RocketList(filteredRocketList, onRocketClicked = {
                                    onItemClick(it)
                                    Log.e("clicked", "flight Number ${it.flightNumber}")
                                })
                            }
                            is Resource.Error<*> -> {
                                val errorMessage = (getRocketDetailsState as Resource.Error).message
                                Text(text = "Error: $errorMessage")
                            }
                        }
                    }
                }

                // Button at the center
                AnimatedVisibility(
                    visible = rocketMainScreenList.isEmpty(),
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Button(onClick = {
                        if(rocketMainScreenList.isEmpty() && !isNetworkAvailable(context)){
                            Toast.makeText(context,"please check your internet",Toast.LENGTH_SHORT).show()
                        }
                        rocketViewModel.getRocketDetails() }) {
                        Text(text = "Fetch Rocket Details")
                    }
                }
            }
        }
    )
}
