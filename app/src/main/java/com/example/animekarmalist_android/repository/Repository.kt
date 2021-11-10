package com.example.animekarmalist_android.repository

import com.example.animekarmalist_android.data.remote.responses.AnimeItemsList
import com.example.animekarmalist_android.util.Resource

interface Repository {
    suspend fun getWeekList(start: String, end: String, offset: Int): Resource<AnimeItemsList>

    suspend fun getSearchList(search: String, offset: Int): Resource<AnimeItemsList>
}