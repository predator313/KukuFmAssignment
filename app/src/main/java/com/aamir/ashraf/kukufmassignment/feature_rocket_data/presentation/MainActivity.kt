package com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.components.screen.MainScreen
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.navigation.MyNavigationHost
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.ui.theme.KukuFmAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KukuFmAssignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    MyNavigationHost()

                }
            }
        }
    }
}


