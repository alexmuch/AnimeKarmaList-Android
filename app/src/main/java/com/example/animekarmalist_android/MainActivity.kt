package com.example.animekarmalist_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.animekarmalist_android.features.common.DetailView
import com.example.animekarmalist_android.features.weeklylist.WeeklyListScreen
import com.example.animekarmalist_android.ui.theme.AnimeKarmaListAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeKarmaListAndroidTheme {
                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//
//                }

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "weekly_list_screen") {
                    composable("weekly_list_screen") {
                        WeeklyListScreen(navController = navController)
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
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnimeKarmaListAndroidTheme {
        Greeting("Android")
    }
}