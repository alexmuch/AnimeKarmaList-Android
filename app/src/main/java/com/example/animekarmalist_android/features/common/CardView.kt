package com.example.animekarmalist_android.features.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animekarmalist_android.R
import com.example.animekarmalist_android.data.remote.responses.AnimeItem

@Composable
fun CardView(
    item: AnimeItem
) {
    val imageResourceId = getImageResourceId(item.imagePath)
    val episodeInfo = formatEpisodeInfo(item)
    val textShadow = MaterialTheme.typography.h4.copy(
        color = Color.White,
        fontSize = 35.sp,
        shadow = Shadow(
            color = Color.Black,
            offset = Offset(2f, 2f),
            blurRadius = 4f
        )
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(3.dp)
            ),
    ) {
        Box(modifier = Modifier.height(88.dp)) {
            Image(
                painter = painterResource(id = imageResourceId),
                contentDescription = "Content description for visually impaired!",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillHeight
            )

            InternalShadow()

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
                        color = Color.White,
                        fontSize = 35.sp,
                        style = textShadow,
                        modifier = Modifier
                            .padding(start = 4.dp)
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
                        style = textShadow,
                        modifier = Modifier
                            .padding(end = 5.dp)
                    )

                    Spacer(modifier = Modifier.weight(1.0f))

                    Text(
                        text = episodeInfo,
                        color = Color.White,
                        fontSize = 15.sp,
                        style = textShadow,
                        modifier = Modifier
                            .padding(bottom = 2.dp, end = 5.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun InternalShadow() {
    // use internal gradient to darken image for text's visual clarity
    // left internal shadow
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 0.2f),
                        Color.Transparent,
                        Color.Transparent,
                        Color.Transparent,
                        Color.Transparent
                    ),
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(Float.POSITIVE_INFINITY, 0f)
                )
            )
    )

    // right internal shadow
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Transparent,
                        Color.Black.copy(alpha = 0.3f)
                    ),
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(Float.POSITIVE_INFINITY, 0f)
                )
            )
    )
}

fun formatEpisodeInfo(item: AnimeItem): String {
    if (item.episodeTotal != null && item.episodeNumber <= item.episodeTotal) {
        return "Episode ${item.episodeNumber}/${item.episodeTotal}"
    } else {
        return "Episode ${item.episodeNumber}"
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