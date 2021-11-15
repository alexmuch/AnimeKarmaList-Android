package com.example.animekarmalist_android.features.weeklylist

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.animekarmalist_android.R
import com.example.animekarmalist_android.data.remote.responses.AnimeItem
import com.example.animekarmalist_android.features.common.CardView

@Composable
fun WeeklyListScreen(
    navController: NavController,
    viewModel: WeeklyListViewModel = hiltViewModel()
) {
    //val weekItems by remember { viewModel.weekItems }

    //MaterialTheme.colors.background
    Surface(color = Color.White) {
//        Text("ayy lmao")
//        Button(onClick = { viewModel.loadListPaginated()}) {
//            Text("test API")
//        }

            AnimeList(navController = navController)

    }
}

@Composable
fun AnimeList(
    navController: NavController,
    viewModel: WeeklyListViewModel = hiltViewModel()
) {
    val weekItems by remember { viewModel.weekItems }

    LazyColumn(contentPadding = PaddingValues(10.dp)) {
        items(weekItems) { item ->
            Box(
                modifier = Modifier
                    .padding(bottom = 6.dp)
                    .clickable {
                    navController.navigate(
                        "item_detail_screen/${item.name}"
                    )
                }
            ) {
                CardView(item)
            }
        }
    }
}

















