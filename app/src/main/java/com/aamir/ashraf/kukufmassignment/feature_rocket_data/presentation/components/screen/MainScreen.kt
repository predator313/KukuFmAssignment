package com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.RocketViewModel
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components.RocketList
import com.aamir.ashraf.kukufmassignment.utils.Resource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    rocketViewModel: RocketViewModel
){
    val getRocketDetailsState by rocketViewModel.getRocketState.collectAsState()

    val rocketMainScreenList by rocketViewModel.rocketMainScreenModelList.collectAsState()



    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { rocketViewModel.getRocketDetails() }) {
                    Text(text = "Fetch Rocket Details")
                }

                when (getRocketDetailsState) {
                    is Resource.Loading<*> -> {
                        Text(text = "Loading...")
                    }
                    is Resource.Success<*> -> {
                        RocketList(rocketMainScreenList)
                    }
                    is Resource.Error<*> -> {
                        val errorMessage = (getRocketDetailsState as Resource.Error).message
                        Text(text = "Error: $errorMessage")
                    }
                }
            }
        }
    )
    }
