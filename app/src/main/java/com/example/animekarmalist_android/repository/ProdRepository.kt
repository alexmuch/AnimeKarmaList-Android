package com.example.animekarmalist_android.repository

import com.example.animekarmalist_android.data.remote.AnimeKarmaListApi
import com.example.animekarmalist_android.data.remote.responses.AnimeItemsList
import com.example.animekarmalist_android.util.Resource

class ProdRepository constructor(
    private val api: AnimeKarmaListApi
) : Repository {
    override suspend fun getWeekList(start: String, end: String, offset: Int): Resource<AnimeItemsList> {
        val response = try {
            api.getWeekList(start, end, offset)
        } catch (e: Exception) {
            return Resource.Error("Network error occurred. Failed to retrieve week list.")
        }

        return Resource.Success(response)
    }

    override suspend fun getSearchList(search: String, offset: Int): Resource<AnimeItemsList> {
        val response = try {
            api.getSearchList(search, offset)
        } catch (e: Exception) {
            return Resource.Error("Network error occurred. Failed to retrieve search list.")
        }

        return Resource.Success(response)
    }
}