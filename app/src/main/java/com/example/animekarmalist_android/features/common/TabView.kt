package com.example.animekarmalist_android.features.common

import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

enum class Tab(val icon: ImageVector) {
    Weekly(Icons.Default.List),
    Search(Icons.Default.Search),
    Settings(Icons.Default.Settings)
}

@Composable
fun TabView(selectedTabIndex: Int, onSelected: (Tab) -> Unit) {
    TabRow(selectedTabIndex = selectedTabIndex) {
        Tab.values().forEachIndexed { index, thisTab ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = { onSelected(thisTab) },
                text = { Text(text = thisTab.name) },
                icon = { Icon(imageVector = thisTab.icon, contentDescription = thisTab.name) }
            )
        }
    }
}