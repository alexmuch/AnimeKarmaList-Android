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
            Box(
                modifier = Modifier.clickable {
                    navController.navigate(
                        "item_detail_screen/${item.name}"
                    )
                }
            ) {
                CardView(navController, item)
            }
        }
    }
}

@Composable
fun CardView(
    navController: NavController,
    item: AnimeItem,
) {
    val imageResourceId = getImageResourceId(item.imagePath)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(modifier = Modifier.height(88.dp)) {
            Image(
                painter = painterResource(id = imageResourceId),
                contentDescription = "Content description for visually impaired!",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillHeight
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(.33f)
                ) {
                    Spacer(modifier = Modifier.weight(1.0f))

                    Text(
                        "${item.karma}",
                        style = MaterialTheme.typography.h4.copy(
                            color = Color.White,
                            fontSize = 35.sp,
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(2f, 2f),
                                blurRadius = 4f
                            )
                        )
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        item.name,
                        color = Color.White,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.h4.copy(
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(2f, 2f),
                                blurRadius = 4f
                            )
                        )
                    )

                    Spacer(modifier = Modifier.weight(1.0f))

                    if (item.episodeTotal != null && item.episodeNumber <= item.episodeTotal) {
                        Text(
                            "Episode ${item.episodeNumber}/${item.episodeTotal}",
                            color = Color.White,
                            fontSize = 15.sp,
                            style = MaterialTheme.typography.h4.copy(
                                shadow = Shadow(
                                    color = Color.Black,
                                    offset = Offset(2f, 2f),
                                    blurRadius = 4f
                                )
                            )
                        )
                    } else {
                        Text(
                            "Episode ${item.episodeNumber}",
                            color = Color.White,
                            fontSize = 15.sp,
                            style = MaterialTheme.typography.h4.copy(
                                shadow = Shadow(
                                    color = Color.Black,
                                    offset = Offset(2f, 2f),
                                    blurRadius = 4f
                                )
                            )
                        )
                    }
                }
            }
        }
    }
}


// input from API looks like`/2020fall/s1kaguya.webp`
// returns the Android resource ID for an image
fun getImageResourceId(imageUrl: String): Int {
    // extract `s1kaguya`
    val name = imageUrl.substringBeforeLast(".").substringAfterLast("/")

    // determine resource ID from name using reflection
    val idFromSearch = R.drawable::class.java.getId(name)
    if (idFromSearch == -1) {
        // if not found in resources, use placeholder
        return R.drawable.aquacrying
    }

    return idFromSearch
}

// from https://stackoverflow.com/a/55465964/2619824
inline fun <reified T : Class<*>> T.getId(resourceName: String): Int {
    return try {
        val idField = getDeclaredField(resourceName)
        idField.getInt(idField)
    } catch (e: Exception) {
        println("Could not find a valid image in res")
        -1
    }
}















