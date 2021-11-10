package com.example.animekarmalist_android.data.remote

import com.example.animekarmalist_android.data.remote.responses.AnimeItemsList
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeKarmaListApi {

    @GET("episodes")
    suspend fun getWeekList(
        @Query("start") start: String,
        @Query("end") end: String,
        @Query("offset") offset: Int
    ) : AnimeItemsList

    suspend fun getSearchList(
        @Query("search") search: String,
        @Query("offset") offset: Int
    ) : AnimeItemsList
}