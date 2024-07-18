package com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.model.RocketDetailScreenModel
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.model.RocketMainScreenModel

@Composable
fun RocketList(rockets: List<RocketMainScreenModel>,onRocketClicked: (RocketMainScreenModel) -> Unit){
    LazyColumn {
        items(rockets) { rocket ->
            RocketCard(rocket,onRocketClicked)

        }
    }

}

@Composable
fun RocketDetail(rocket: RocketDetailScreenModel){

        RocketDetailCard(rocketMainScreenModel = rocket)




}