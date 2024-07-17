package com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.RocketViewModel
import com.aamir.ashraf.kukufmassignment.utils.Resource

@Composable
fun MainScreen(
    rocketViewModel: RocketViewModel
){
    val getRocketDetailsState by rocketViewModel.getRocketState.collectAsState()

    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
        .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = { rocketViewModel.getRocketDetails() }) {
            Text(text = "Home Screen")
        }
        when(getRocketDetailsState){
            is Resource.Loading<*> -> {
                Text(text = "Loading...")
            }
            is Resource.Success<*> -> {
                val response = (getRocketDetailsState as Resource.Success).data
                Text(text = "Success: ${response?: "Body is Empty"}")
            }
            is Resource.Error<*> -> {
                val errorMessage = (getRocketDetailsState as Resource.Error).message
                Text(text = "Error: $errorMessage")
            }
        }
    }
    }
