package com.example.animekarmalist_android.features.weeklylist

//import com.example.animekarmalist_android.repository.TestRepository
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animekarmalist_android.data.remote.responses.AnimeItem
import com.example.animekarmalist_android.data.remote.responses.AnimeItemsList
import com.example.animekarmalist_android.repository.Repository
import com.example.animekarmalist_android.util.Resource
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
        println("loading list")

        viewModelScope.launch {
            val result = repository.getWeekList("2021-01-08T21:00:00Z", "2021-01-15T23:00:00Z", 0)

            when (result) {
                is Resource.Success -> {
                    weekItems.value += result.data as AnimeItemsList

                    println(weekItems.value.toString())
                }

                is Resource.Loading -> {
                    //TODO
                }

                is Resource.Error -> {
                    println("Error calling API")
                }
            }
        }
    }
}
