package com.example.animekarmalist_android.features.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.animekarmalist_android.data.remote.responses.AnimeItem

@Composable
fun DetailView(
    navController: NavController,
    item: AnimeItem
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .background(
                    Color.Black
                )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(36.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
        }

        Column(
            verticalArrangement = Arrangement.Top,
        ) {

            if (item.imagePath != null) {
                val imageResourceId = getImageResourceId(item.imagePath)
                Image(
                    painter = painterResource(id = imageResourceId),
                    contentDescription = "Content description for visually impaired!",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            }

            Text(
                item.name!!,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                item.utcTime!!,
                fontSize = 15.sp
            )

            Divider()

            // episode X data
            Row {
                Spacer(modifier = Modifier.weight(1.0f))

                Text(
                    "Episode ${item.episodeNumber!!} Data",
                    fontSize = 21.sp
                )

                Spacer(modifier = Modifier.weight(1.0f))
            }


            // reddit data upvotes, comments, score
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Spacer(modifier = Modifier.weight(1.0f))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(Color.Red)
                    ) {
                        Text("${item.karma!!}")
                    }

                    Text("Karma", fontSize = 15.sp)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(Color.Red)
                    ) {
                        Text("${item.commentCount!!}")
                    }

                    Text("Comments", fontSize = 15.sp)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(Color.Red)
                    ) {
                        Text("${item.score!!}/5")
                    }

                    Text("Score", fontSize = 15.sp)
                }
                Spacer(modifier = Modifier.weight(1.0f))
            }

            // divider?
            Divider()

            // season data
            Row {
                Spacer(modifier = Modifier.weight(1.0f))

                Text(
                    "Season Data",
                    fontSize = 21.sp
                )

                Spacer(modifier = Modifier.weight(1.0f))
            }

            // score bubbles MAL Ani

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Spacer(modifier = Modifier.weight(1.0f))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(Color.Red)
                    ) {
                        Text("${item.malScore!!}/10")
                    }

                    Text("MyAnimeList", fontSize = 15.sp)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(Color.Red)
                    ) {
                        Text("${item.anilistScore!!}/100")
                    }

                    Text("Anilist", fontSize = 15.sp)
                }
                Spacer(modifier = Modifier.weight(1.0f))
            }
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .size(80.dp)
//                    .clip(CircleShape)
//                    .background(Color.Red)
//            ) {
//                Text("${item.malScore!!}/10")
//            }


            // subreddit
            // studio
            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(10.dp)) {
                Box(modifier = Modifier.clip(RoundedCornerShape(10.dp))) {
                    Text(
                        item.subredditLink!!,
                        modifier = Modifier
                            .background(Color.Red)
                            .padding(10.dp)
                            .clip(
                                RoundedCornerShape(10.dp)
                            )
                    )
                }

                Text("Subreddit", fontSize = 15.sp)
            }

            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(10.dp)) {
                Box(modifier = Modifier.clip(RoundedCornerShape(10.dp))) {
                    Text(
                        item.studio!!,
                        modifier = Modifier
                            .background(Color.Red)
                            .padding(10.dp)
                    )
                }

                Text("Studio", fontSize = 15.sp)
            }


            // streams

            // genres

            // summary
            Row(modifier = Modifier.padding(10.dp)) {
                Text(item.summary!!, fontSize = 15.sp)
            }


        }
    }

}