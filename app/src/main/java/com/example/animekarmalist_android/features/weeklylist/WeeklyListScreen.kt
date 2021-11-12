package com.example.animekarmalist_android.features.weeklylist

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.animekarmalist_android.R
import com.example.animekarmalist_android.data.remote.responses.AnimeItem

@Composable
fun WeeklyListScreen(
    navController: NavController,
    viewModel: WeeklyListViewModel = hiltViewModel()
) {
    //val weekItems by remember { viewModel.weekItems }

    Surface(color = MaterialTheme.colors.background) {
//        Text("ayy lmao")
//        Button(onClick = { viewModel.loadListPaginated()}) {
//            Text("test API")
//        }
        Column {
            AnimeList(navController = navController)
        }
    }
}

@Composable
fun AnimeList(
    navController: NavController,
    viewModel: WeeklyListViewModel = hiltViewModel()
) {
    val weekItems by remember { viewModel.weekItems }

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(weekItems) { item ->
            CardView(navController, item)
        }
    }
}

@Composable
fun CardView(
    navController: NavController,
    animeItem: AnimeItem,
) {
    var resourceId = R.drawable.aquacrying
    
    val idFromSearch = R.drawable::class.java.getId("toyoureternity")
    
    if (idFromSearch != -1) {
        resourceId = idFromSearch
    }
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(modifier = Modifier.height(88.dp)) {
            Image(
                painter = painterResource(id = resourceId),
                contentDescription = "Content description for visually impaired!",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillHeight
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Text("Blah blah blah", style = TextStyle(color = Color.Black, fontSize = 20.sp))
            }
        }
    }
}

inline fun <reified T: Class<*>> T.getId(resourceName: String): Int {
    try {
        val idField = getDeclaredField (resourceName)
        return idField.getInt(idField)
    } catch (e:Exception) {
        //e.printStackTrace()
        println("Could not find a valid image")
        return -1
    }
}















