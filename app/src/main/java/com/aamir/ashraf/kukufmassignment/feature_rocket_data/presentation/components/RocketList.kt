package com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.model.RocketDetailScreenModel
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.model.RocketMainScreenModel

@Composable
fun RocketList(rocket: List<RocketMainScreenModel>){
    LazyColumn {
        items(rocket) { user ->
            RocketCard(user)
        }
    }

}

@Composable
fun RocketDetailList(rocket: List<RocketDetailScreenModel>){
    LazyColumn {
        items(rocket) { user ->
            RocketDetailCard(user)
        }
    }

}