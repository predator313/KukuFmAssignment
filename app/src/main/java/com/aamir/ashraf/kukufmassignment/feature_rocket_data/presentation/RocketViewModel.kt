package com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.dto.RocketDetailsDto
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.use_case.GetRocketDetailUseCase
import com.aamir.ashraf.kukufmassignment.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RocketViewModel @Inject constructor(
    private val getRocketDetailUseCase: GetRocketDetailUseCase
) :ViewModel(){
    private val _getRocketState = MutableStateFlow<Resource<List<RocketDetailsDto>>>(Resource.Loading())
    val getRocketState:StateFlow<Resource<List<RocketDetailsDto>>> = _getRocketState

    fun getRocketDetails(){
        Log.e("kuku","inside viewmodel getRocketDetails")
        viewModelScope.launch {
            _getRocketState.value = Resource.Loading()
            val result = withContext(Dispatchers.IO){
                getRocketDetailUseCase.getRocketDetails()
            }
            _getRocketState.value= result
        }
    }

}