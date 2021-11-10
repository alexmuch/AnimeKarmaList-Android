package com.example.animekarmalist_android.repository
//
//import com.example.animekarmalist_android.data.remote.AnimeKarmaListApi
//import com.example.animekarmalist_android.data.remote.responses.AnimeItemsList
//import com.example.animekarmalist_android.data.remote.responses.AnimeListItem
//import com.example.animekarmalist_android.util.Resource
//import dagger.hilt.android.scopes.ActivityScoped
//import javax.inject.Inject
//
//@ActivityScoped
//class TestRepository: Repository {
//
//    override suspend fun getWeekList(start: String, end: String, offset: Int): Resource<AnimeItemsList> {
//        var item = AnimeListItem(
//
//        )
//
//        var response = AnimeItemsList()
//
//        return Resource.Success(response)
//    }
//
//    override suspend fun getSearchList(search: String, offset: Int): Resource<AnimeItemsList> {
//
//
//        return Resource.Success(response)
//    }
//}