package com.example.animekarmalist_android.features.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailView(
    name: String?
) {
    Box() {
        Text(name!!)
    }
}