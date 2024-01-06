package com.example.myapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.data.HomeRepository
import com.example.myapp.data.Resource
import com.example.myapp.model.Colleges
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository : HomeRepository
) : ViewModel() {

    private val _collegeData = MutableStateFlow<Resource<Colleges>?>(null)
    val collegeData : StateFlow<Resource<Colleges>?> = _collegeData

    fun getDataFromRepo() = viewModelScope.launch {
        _collegeData.value = Resource.Loading
        delay(1000)
        val result = homeRepository.fetchDataFromFirebase()
        _collegeData.value = result
    }
}