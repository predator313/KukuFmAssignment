package com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.model.RocketDetailScreenModel
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.model.RocketMainScreenModel

@Composable
fun RocketCard(rocketMainScreenModel: RocketMainScreenModel,onRocketClicked:(RocketMainScreenModel)->Unit){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onRocketClicked(rocketMainScreenModel) }
        ,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Mission Name: ${rocketMainScreenModel.missionName}", style = MaterialTheme.typography.headlineSmall)
            Text(text = "Launch Year: ${rocketMainScreenModel.launchYear}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Rocket Name: ${rocketMainScreenModel.rocketName}", style = MaterialTheme.typography.bodyLarge)

        }
    }

}

@Composable
fun RocketDetailCard(rocketMainScreenModel: RocketDetailScreenModel){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Mission Name: ${rocketMainScreenModel.missionName}", style = MaterialTheme.typography.headlineSmall)
            Text(text = "Launch Year: ${rocketMainScreenModel.launchYear}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Rocket Name: ${rocketMainScreenModel.rocketName}", style = MaterialTheme.typography.bodyLarge)

        }
    }

}