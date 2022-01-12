package com.example.animekarmalist_android.features.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.animekarmalist_android.data.remote.responses.AnimeItem

@Composable
fun DetailView(
    navController: NavController,
    item: AnimeItem
) {
    Column {
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

        Box() {
            Text(item.name!!)
        }
    }

}