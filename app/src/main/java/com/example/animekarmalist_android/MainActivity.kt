package com.example.animekarmalist_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.animekarmalist_android.features.common.TabView
import com.example.animekarmalist_android.features.common.Tab
import com.example.animekarmalist_android.features.weeklylist.WeeklyListScreen
import com.example.animekarmalist_android.ui.theme.AnimeKarmaListAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeKarmaListAndroidTheme {
                var currentTab by remember { mutableStateOf(Tab.Weekly) }

                Scaffold(bottomBar = {
                    TabView(
                        selectedTabIndex = currentTab.ordinal,
                        onSelected = { currentTab = it }
                    )
                }) {
                    when (currentTab) {
                        Tab.Weekly -> WeeklyListScreen()
                        Tab.Search -> Text(text = "ayy lmao")
                        Tab.Settings -> Text(text = "ayy lmao2")
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