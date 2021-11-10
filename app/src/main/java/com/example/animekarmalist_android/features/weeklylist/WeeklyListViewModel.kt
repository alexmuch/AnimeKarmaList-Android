package com.example.animekarmalist_android.features.weeklylist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animekarmalist_android.repository.ProdRepository
import com.example.animekarmalist_android.repository.Repository
//import com.example.animekarmalist_android.repository.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class WeeklyListViewModel @Inject constructor(
    @Named("ProdImplementation") private val repository: Repository
) : ViewModel() {

    init {
    }

    fun testApi() {
        Log.d("TAG", "api clicked")

        viewModelScope.launch {
            val blah = repository.getWeekList("2021-01-08T21:00:00Z", "2021-01-15T23:00:00Z", 0)
            print(blah)
            Log.d("TAG", blah.data.toString())
        }
    }
}
