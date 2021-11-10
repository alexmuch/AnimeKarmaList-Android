package com.example.animekarmalist_android.features.weeklylist

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun WeeklyListScreen(    
    viewModel: WeeklyListViewModel = hiltViewModel()
) {
    // A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colors.background) {
        Text("ayy lmao")
        Button(onClick = { viewModel.testApi()}) {
            Text("test API")
        }
    }
}