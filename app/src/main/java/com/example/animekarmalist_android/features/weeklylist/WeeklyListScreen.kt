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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animekarmalist_android.data.remote.responses.AnimeItem
import com.example.animekarmalist_android.features.common.CardView
import com.example.animekarmalist_android.features.common.DetailView
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

val ROUTE_ITEM_DETAILS = "item-details?item={item}"

@Composable
fun WeeklyListScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "weekly_list_screen") {
        composable("weekly_list_screen") {
            AnimeList(navController = navController)
        }

        composable(ROUTE_ITEM_DETAILS) { backStackEntry ->
            val itemJson = backStackEntry.arguments?.getString("item")
            val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
            val jsonAdapter = moshi.adapter(AnimeItem::class.java).lenient()
            val itemObject = jsonAdapter.fromJson(itemJson!!)

            if (itemObject != null) {
                DetailView(navController = navController, itemObject)
            }
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
                        val moshi = Moshi
                            .Builder()
                            .addLast(KotlinJsonAdapterFactory())
                            .build()
                        val jsonAdapter = moshi
                            .adapter(AnimeItem::class.java)
                            .lenient()
                        val itemJson = jsonAdapter.toJson(item)

                        navController.navigate(
                            ROUTE_ITEM_DETAILS.replace("{item}", itemJson)
                        )
                    }
            ) {
                CardView(item)
            }
        }
    }
}








