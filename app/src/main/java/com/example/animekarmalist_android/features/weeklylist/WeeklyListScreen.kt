package com.example.animekarmalist_android.features.weeklylist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.animekarmalist_android.features.common.CardView
import com.example.animekarmalist_android.features.common.DetailView

@Composable
fun WeeklyListScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "weekly_list_screen") {
        composable("weekly_list_screen") {
            AnimeList(navController = navController)
        }

        composable(
            "item_detail_screen/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                }
            )
        ) {
            val name = remember {
                it.arguments?.getString("name")
            }

            DetailView(navController = navController, name)
        }
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

















