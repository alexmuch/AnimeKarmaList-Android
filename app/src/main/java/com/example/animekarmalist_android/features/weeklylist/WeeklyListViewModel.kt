package com.example.animekarmalist_android.features.weeklylist

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animekarmalist_android.data.remote.responses.AnimeItem
import com.example.animekarmalist_android.data.remote.responses.AnimeItemsList
import com.example.animekarmalist_android.repository.Repository
import com.example.animekarmalist_android.util.Resource
//import com.example.animekarmalist_android.repository.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class WeeklyListViewModel @Inject constructor(
    @Named("TestImplementation") private val repository: Repository
) : ViewModel() {
    var weekItems = mutableStateOf<List<AnimeItem>>(listOf())

    init {
        loadListPaginated()
    }

    fun loadListPaginated() {
        Log.d("TAG", "loading list")

        viewModelScope.launch {
            val result = repository.getWeekList("2021-01-08T21:00:00Z", "2021-01-15T23:00:00Z", 0)

            when(result) {
                is Resource.Success -> {
                    weekItems.value += result.data as AnimeItemsList

                    Log.d("TAG", weekItems.value.toString())
                }

                is Resource.Error -> {
                    Log.d("TAG", "Error calling API")
                }
            }
        }
    }
}
